package com.pixilaremedia.thrivecraft.util.materials;

import com.pixilaremedia.thrivecraft.init.ItemInit;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.function.Supplier;

@SuppressWarnings("deprecation")
public enum CustomToolMaterial implements Tier
{
    ONYX(4, 1942, 9.0f, 4.0f, 10, () -> { return Ingredient.of(new ItemLike[]{ItemInit.ONYX_GEM.get()}); }),
    TOOTHY(2, 250, 2.0f, 6.0f, 14, () -> { return Ingredient.of(new ItemLike[]{ItemInit.DRACULA_FANG.get()}); });

    private final int level, uses, enchantmentValue;
    private final float speed, damage;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    private CustomToolMaterial(int level, int uses, float speed, float damage, int enchantmentValue, Supplier<Ingredient> repairIngredient)
    {
        this.level = level;
        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
    }

    @Override
    public int getUses() {
        return this.uses;
    }

    @Override
    public float getSpeed() {
        return this.speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.damage;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
