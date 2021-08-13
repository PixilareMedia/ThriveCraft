package com.pixilaremedia.thrivecraft.items;

import com.pixilaremedia.thrivecraft.init.ItemInit;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Wearable;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;

import javax.annotation.Nullable;

public class DraculaElytra extends Item implements Wearable
{
    public DraculaElytra(Properties properties) {
        super(properties);
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);
    }

    public static boolean isFlyEnabled(ItemStack item)
    {
        return item.getDamageValue() < item.getMaxDamage() -1;
    }

    public boolean isValidRepairItem(ItemStack item, ItemStack item2)
    {
        return item2.is(ItemInit.DRACULA_MEMBRANE.get());
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand)
    {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        EquipmentSlot equipmentSlot = Mob.getEquipmentSlotForItem(itemStack);
        ItemStack itemStack1 = player.getItemBySlot(equipmentSlot);
        if(itemStack1.isEmpty())
        {
            player.setItemSlot(equipmentSlot, itemStack.copy());
            if(level.isClientSide())
            {
                player.awardStat(Stats.ITEM_USED.get(this));
            }
            itemStack.setCount(0);
            return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
        } else {
            return InteractionResultHolder.fail(itemStack);
        }
    }

    @Override
    public boolean canElytraFly(ItemStack stack, LivingEntity entity)
    {
        return DraculaElytra.isFlyEnabled(stack);
    }

    @Override
    public boolean elytraFlightTick(ItemStack stack, LivingEntity entity, int flightTicks)
    {
        if(!entity.level.isClientSide && (flightTicks + 1) % 20 == 0)
        {
            stack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(EquipmentSlot.CHEST));
        }
        return true;
    }

    @Nullable
    public SoundEvent getEquipSound()
    {
        return SoundEvents.ARMOR_EQUIP_ELYTRA;
    }
}
