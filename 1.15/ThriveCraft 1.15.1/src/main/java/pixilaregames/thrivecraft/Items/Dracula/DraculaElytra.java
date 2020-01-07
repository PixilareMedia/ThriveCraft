package pixilaregames.thrivecraft.Items.Dracula;

import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import pixilaregames.thrivecraft.Lists.ItemList;

public class DraculaElytra extends Item
{
	public DraculaElytra(Item.Properties builder)
	{
		super(builder);
		this.addPropertyOverride(new ResourceLocation("broken"), (p_210312_0_, p_210312_1_, p_210312_2_) -> {
			return isUsable(p_210312_0_) ? 0.0f : 1.0f;
		});
		DispenserBlock.registerDispenseBehavior(this, ArmorItem.DISPENSER_BEHAVIOR);
	}
	
	public static boolean isUsable(ItemStack stack)
	{
		return stack.getDamage() < stack.getMaxDamage() -1;
	}
	
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
	{
		return repair.getItem() == ItemList.dracula_membrane;
	}
	
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
	{
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		EquipmentSlotType equipmentslottype = MobEntity.getSlotForItemStack(itemstack);
		ItemStack itemstack1 = playerIn.getItemStackFromSlot(equipmentslottype);
		if(itemstack1.isEmpty())
		{
			playerIn.setItemStackToSlot(equipmentslottype, itemstack.copy());
			itemstack.setCount(0);
			return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
		} else {
			return new ActionResult<>(ActionResultType.FAIL, itemstack);
		}
	}
}
