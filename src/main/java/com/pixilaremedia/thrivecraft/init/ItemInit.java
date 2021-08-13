package com.pixilaremedia.thrivecraft.init;

import com.pixilaremedia.thrivecraft.Ref;
import com.pixilaremedia.thrivecraft.items.DraculaElytra;
import com.pixilaremedia.thrivecraft.util.materials.CustomArmourMaterial;
import com.pixilaremedia.thrivecraft.util.materials.CustomToolMaterial;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ref.MODID);

    //Misc Stuff
    public static RegistryObject<Item> ENTITY_EGG;

    //Onyx Stuff
    //Item
    public static RegistryObject<Item> ONYX_GEM = ITEMS.register("onyx_gem", () -> new Item(new Item.Properties().tab(Ref.TRIVECRAFT_TAB)));
    //Tools
    public static RegistryObject<Item> ONYX_SWORD = ITEMS.register("onyx_sword", () -> new SwordItem(CustomToolMaterial.ONYX, 0, 6.0f, new Item.Properties().tab(Ref.TRIVECRAFT_TAB)));
    public static RegistryObject<Item> ONYX_AXE = ITEMS.register("onyx_axe", () -> new AxeItem(CustomToolMaterial.ONYX, -1.0f, 6.0f, new Item.Properties().tab(Ref.TRIVECRAFT_TAB)));
    public static RegistryObject<Item> ONYX_PICKAXE = ITEMS.register("onyx_pickaxe", () -> new PickaxeItem(CustomToolMaterial.ONYX, -2, 6.0f, new Item.Properties().tab(Ref.TRIVECRAFT_TAB)));
    public static RegistryObject<Item> ONYX_SHOVEL = ITEMS.register("onyx_shovel", () -> new ShovelItem(CustomToolMaterial.ONYX, -1.0f, 6.0f, new Item.Properties().tab(Ref.TRIVECRAFT_TAB)));
    public static RegistryObject<Item> ONYX_HOE = ITEMS.register("onyx_hoe", () -> new HoeItem(CustomToolMaterial.ONYX, 0, 6.0f, new Item.Properties().tab(Ref.TRIVECRAFT_TAB)));
    //Armour
    public static RegistryObject<Item> ONYX_HELMET = ITEMS.register("onyx_helmet", () -> new ArmorItem(CustomArmourMaterial.ONYX, EquipmentSlot.HEAD, new Item.Properties().tab(Ref.TRIVECRAFT_TAB)));
    public static RegistryObject<Item> ONYX_CHESTPLATE = ITEMS.register("onyx_chestplate", () -> new ArmorItem(CustomArmourMaterial.ONYX, EquipmentSlot.CHEST, new Item.Properties().tab(Ref.TRIVECRAFT_TAB)));
    public static RegistryObject<Item> ONYX_LEGGINGS = ITEMS.register("onyx_leggings", () -> new ArmorItem(CustomArmourMaterial.ONYX, EquipmentSlot.LEGS, new Item.Properties().tab(Ref.TRIVECRAFT_TAB)));
    public static RegistryObject<Item> ONYX_BOOTS = ITEMS.register("onyx_boots", () -> new ArmorItem(CustomArmourMaterial.ONYX, EquipmentSlot.FEET, new Item.Properties().tab(Ref.TRIVECRAFT_TAB)));

    //Dracula Stuff
    //Items
    public static RegistryObject<Item> DRACULA_FANG = ITEMS.register("dracula_fang", () -> new Item(new Item.Properties().tab(Ref.TRIVECRAFT_TAB)));
    public static RegistryObject<Item> DRACULA_MEMBRANE = ITEMS.register("dracula_membrane", () -> new Item(new Item.Properties().tab(Ref.TRIVECRAFT_TAB)));
    public static RegistryObject<Item> DRACULA_WING = ITEMS.register("dracula_wing", () -> new Item(new Item.Properties().tab(Ref.TRIVECRAFT_TAB)));
    //Tools
    public static RegistryObject<Item> TOOTHY_SWORD = ITEMS.register("toothy_sword", () -> new SwordItem(CustomToolMaterial.TOOTHY, 0, 6.0f, new Item.Properties().tab(Ref.TRIVECRAFT_TAB)));
    public static RegistryObject<Item> TOOTHY_AXE= ITEMS.register("toothy_axe", () -> new AxeItem(CustomToolMaterial.TOOTHY, -1.0f, 6.0f, new Item.Properties().tab(Ref.TRIVECRAFT_TAB)));
    public static RegistryObject<Item> TOOTHY_PICKAXE = ITEMS.register("toothy_pickaxe", () -> new PickaxeItem(CustomToolMaterial.TOOTHY, -2, 6.0f, new Item.Properties().tab(Ref.TRIVECRAFT_TAB)));
    public static RegistryObject<Item> TOOTHY_SHOVEL = ITEMS.register("toothy_shovel", () -> new ShovelItem(CustomToolMaterial.TOOTHY, -1.0f, 6.0f, new Item.Properties().tab(Ref.TRIVECRAFT_TAB)));
    public static RegistryObject<Item> TOOTHY_HOE = ITEMS.register("toothy_hoe", () -> new HoeItem(CustomToolMaterial.TOOTHY, 0, 6.0f, new Item.Properties().tab(Ref.TRIVECRAFT_TAB)));
    //Armor
    public static RegistryObject<Item> DRACULA_ELYTRA = ITEMS.register("dracula_elytra", () -> new DraculaElytra(new Item.Properties().durability(432).tab(Ref.TRIVECRAFT_TAB).rarity(Rarity.UNCOMMON)));
    public static RegistryObject<Item> TOOTHY_HELMET = ITEMS.register("toothy_helmet", () -> new ArmorItem(CustomArmourMaterial.TOOTHY, EquipmentSlot.HEAD, new Item.Properties().tab(Ref.TRIVECRAFT_TAB)));
    public static RegistryObject<Item> TOOTHY_CHESTPLATE = ITEMS.register("toothy_chestplate", () -> new ArmorItem(CustomArmourMaterial.TOOTHY, EquipmentSlot.CHEST, new Item.Properties().tab(Ref.TRIVECRAFT_TAB)));
    public static RegistryObject<Item> TOOTHY_LEGGINGS = ITEMS.register("toothy_leggings", () -> new ArmorItem(CustomArmourMaterial.TOOTHY, EquipmentSlot.LEGS, new Item.Properties().tab(Ref.TRIVECRAFT_TAB)));
    public static RegistryObject<Item> TOOTHY_BOOTS = ITEMS.register("toothy_boots", () -> new ArmorItem(CustomArmourMaterial.TOOTHY, EquipmentSlot.FEET, new Item.Properties().tab(Ref.TRIVECRAFT_TAB)));

    //Black Widow Stuff
    public static RegistryObject<Item> SPIDER_LEG = ITEMS.register("spider_leg", () -> new Item(new Item.Properties().tab(Ref.TRIVECRAFT_TAB)));
}
