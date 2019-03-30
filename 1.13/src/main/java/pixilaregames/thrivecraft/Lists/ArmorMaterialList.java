package pixilaregames.thrivecraft.Lists;

import java.util.function.Supplier;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyLoadBase;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public enum ArmorMaterialList implements IArmorMaterial
{
	Onyx("onyx", 34, new int[] {4, 7, 9, 4}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.0f, () -> { return Ingredient.fromItems(ItemList.onyx_gem);}),
	Toothy("toothy", 15, new int[] {1, 4, 5, 2}, 15, SoundEvents.ITEM_ARMOR_EQUIP_TURTLE, 0.0f, () -> { return Ingredient.fromItems(ItemList.dracula_fang);});
	
	private static final int[] MAX_DAMAGE_ARRAY = new int[] {13, 15, 16, 11};
	private final String name;
	private final int maxDamageFactor;
	private final int[] damageReductionAmountArray;
	private final int enchantibility;
	private final SoundEvent soundEvent;
	private final float toughness;
	private final LazyLoadBase<Ingredient> repairMaterial;
	
	private ArmorMaterialList(String nameIn, int maxdamageFactor, int[] damagereductionAmountArray, int enchantablity, SoundEvent soundevent, float toughness, Supplier<Ingredient> repairmaterial)
	{
		this.name = nameIn;
		this.maxDamageFactor = maxdamageFactor;
		this.damageReductionAmountArray = damagereductionAmountArray;
		this.enchantibility = enchantablity;
		this.soundEvent = soundevent;
		this.toughness = toughness;
		this.repairMaterial = new LazyLoadBase<>(repairmaterial);
	}
	
	public int getDurability(EntityEquipmentSlot slotIn)
	{
		return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
	}
	
	public int getDamageReductionAmount(EntityEquipmentSlot slotIn)
	{
		return this.damageReductionAmountArray[slotIn.getIndex()];
	}
	
	public int getEnchantability()
	{
		return this.enchantibility;
	}
	
	public SoundEvent getSoundEvent()
	{
		return this.soundEvent;
	}
	
	public Ingredient getRepairMaterial()
	{
		return this.repairMaterial.getValue();
	}
	
	@OnlyIn(Dist.CLIENT)
	public String getName()
	{
		return this.name;
	}
	
	public float getToughness()
	{
		return this.toughness;
	}
	
}
