package pixilaregames.thrivecraft.Lists;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import pixilaregames.thrivecraft.ThriveCraft;

public enum ArmorMaterialList implements IArmorMaterial
{
	Onyx("onyx", 34, new int[] {4, 7, 9, 4}, 10, ItemList.onyx_gem, "entity.ender_dragon.growl", 3.0f),
	Toothy("toothy", 15, new int[] {1, 4, 5, 2}, 15, ItemList.dracula_fang, "entity.ender_dragon.growl", 0.0f);
	
	private static final int[] MAX_DAMAGE_ARRAY = new int[] {13, 15, 16, 11};
	private final String name, equipSound;
	private final int durability, enchantibility;
	private Item repairItem;
	private int[] damageReductionAmounts;
	private float toughness;
	
	private ArmorMaterialList(String name, int durability, int[] damageReductionAmounts, int enchantablity, Item repairItem, String equipSound, float toughness)
	{
		this.name = name;
		this.equipSound = equipSound;
		this.durability = durability;
		this.enchantibility = enchantablity;
		this.repairItem = repairItem;
		this.damageReductionAmounts = damageReductionAmounts;
		this.toughness = toughness;
	}
	
	public int getDurability(EquipmentSlotType slotIn)
	{
		return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.durability;
	}
	
	public int getDamageReductionAmount(EquipmentSlotType slotIn)
	{
		return this.damageReductionAmounts[slotIn.getIndex()];
	}
	
	public int getEnchantability()
	{
		return this.enchantibility;
	}
	
	public SoundEvent getSoundEvent()
	{
		return new SoundEvent(new ResourceLocation(equipSound));
	}
	
	public Ingredient getRepairMaterial()
	{
		return Ingredient.fromItems(this.repairItem);
	}
	
	public String getName()
	{
		return ThriveCraft.modid + ":" + this.name;
	}
	
	public float getToughness()
	{
		return this.toughness;
	}
	
}
