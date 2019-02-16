package com.pixilaregames.thrivecraft.init;

import java.util.ArrayList;
import java.util.List;

import com.pixilaregames.thrivecraft.items.ItemBase;
import com.pixilaregames.thrivecraft.items.Onyx;
import com.pixilaregames.thrivecraft.items.armor.ArmorBase;
import com.pixilaregames.thrivecraft.items.tools.ToolAxe;
import com.pixilaregames.thrivecraft.items.tools.ToolHoe;
import com.pixilaregames.thrivecraft.items.tools.ToolPickaxe;
import com.pixilaregames.thrivecraft.items.tools.ToolSpade;
import com.pixilaregames.thrivecraft.items.tools.ToolSword;
import com.pixilaregames.thrivecraft.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {
	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//Materials
	public static final ToolMaterial MATERIAL_ONYX = EnumHelper.addToolMaterial("material_onyx", 4, 1942, 9.0F, 4.0F, 10);
	public static final ArmorMaterial ARMOR_MATERIAL_ONYX = EnumHelper.addArmorMaterial("armor_material_onyx", Reference.MOD_ID + ":onyx", 15, new int[]{4, 7, 9, 4}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0f);
	
	//Items
	public static final Item ONYX = new Onyx("onyx");
	
	//Tools
	public static final ItemSword ONYX_SWORD = new ToolSword("onyx_sword", MATERIAL_ONYX);
	public static final ItemSpade ONYX_SHOVEL = new ToolSpade("onyx_shovel", MATERIAL_ONYX);
	public static final ItemPickaxe ONYX_PICKAXE = new ToolPickaxe("onyx_pickaxe", MATERIAL_ONYX);
	public static final ItemAxe ONYX_AXE = new ToolAxe("onyx_axe", MATERIAL_ONYX);
	public static final ItemHoe ONYX_HOE = new ToolHoe("onyx_hoe", MATERIAL_ONYX);
	
	//Armor
	public static final Item ONYX_HELMET = new ArmorBase("onyx_helmet", ARMOR_MATERIAL_ONYX, 1, EntityEquipmentSlot.HEAD);
	public static final Item ONYX_CHESTPLATE = new ArmorBase("onyx_chestplate", ARMOR_MATERIAL_ONYX, 1, EntityEquipmentSlot.CHEST);
	public static final Item ONYX_LEGGINGS = new ArmorBase("onyx_leggings", ARMOR_MATERIAL_ONYX, 2, EntityEquipmentSlot.LEGS);
	public static final Item ONYX_BOOTS = new ArmorBase("onyx_boots", ARMOR_MATERIAL_ONYX, 1, EntityEquipmentSlot.FEET);

}
