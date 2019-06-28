package pixilaregames.thrivecraft.Lists;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;

public enum ToolMaterialList implements IItemTier
{
	onyx(4.0f, 9.0f, 1942, 4, 10, ItemList.onyx_gem);
	//toothy(6.0f, 2.0f, 250, 2, 14, ItemList.dracula_fang);
	
	private float attackDamage, efficiency;
	private int durablity, harvestLevel, enchantablity;
	private Item repairMaterial;
	
	private ToolMaterialList(float attackDamage, float efficiency, int durablity, int harvestLevel, int enchantablity, Item repairMaterial)
	{
		this.attackDamage = attackDamage;
		this.efficiency = efficiency;
		this.durablity = durablity;
		this.harvestLevel = harvestLevel;
		this.enchantablity = enchantablity;
		this.repairMaterial = repairMaterial;
	}
	
	@Override
	public int getMaxUses()
	{
		return this.durablity;
	}

	@Override
	public float getEfficiency()
	{
		return this.efficiency;
	}

	@Override
	public float getAttackDamage()
	{
		return this.attackDamage;
	}

	@Override
	public int getHarvestLevel()
	{
		return this.harvestLevel;
	}

	@Override
	public int getEnchantability()
	{
		return this.enchantablity;
	}

	@Override
	public Ingredient getRepairMaterial()
	{
		return Ingredient.fromItems(this.repairMaterial);
	}
}
