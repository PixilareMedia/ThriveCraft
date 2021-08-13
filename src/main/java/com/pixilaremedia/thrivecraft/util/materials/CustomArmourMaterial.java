package com.pixilaremedia.thrivecraft.util.materials;

import com.pixilaremedia.thrivecraft.init.ItemInit;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.function.Supplier;

@SuppressWarnings("deprecation")
public enum CustomArmourMaterial implements ArmorMaterial
{
    ONYX("onyx", 34, new int[] {4, 7, 9, 4}, 10, SoundEvents.ENDER_DRAGON_GROWL, 3.0f, 0.0f, () -> { return Ingredient.of(new ItemLike[]{ItemInit.ONYX_GEM.get()}); }),
    TOOTHY("toothy", 15, new int[] {1, 4, 5, 2}, 15, SoundEvents.ENDER_DRAGON_GROWL, 0.0f, 0.0f, () -> { return Ingredient.of(new ItemLike[]{ItemInit.DRACULA_FANG.get()}); });

    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
    private final int[] slotProtections;
    private final int durabilityMultiplier, enchantmentValue;
    private final float toughness, knockbackResistance;
    private final String name;
    private final SoundEvent sound;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    private CustomArmourMaterial(String name, int durabilityMultiplier, int[] slotProtections, int enchantmentValue, SoundEvent sound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.slotProtections = slotProtections;
        this.enchantmentValue = enchantmentValue;
        this.sound = sound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = new LazyLoadedValue(repairIngredient);
    }

    @Override
    public int getDurabilityForSlot(EquipmentSlot equipmentSlot) {
        return HEALTH_PER_SLOT[equipmentSlot.getIndex()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot equipmentSlot) {
        return this.slotProtections[equipmentSlot.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.sound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
