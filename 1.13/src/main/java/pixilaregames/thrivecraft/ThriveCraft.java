package pixilaregames.thrivecraft;

import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mojang.brigadier.CommandDispatcher;

import net.minecraft.block.Block;
import net.minecraft.block.Block.Properties;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.command.CommandSource;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import pixilaregames.thrivecraft.blocks.onyx.Onyx_Block;
import pixilaregames.thrivecraft.blocks.onyx.Onyx_Ore;
import pixilaregames.thrivecraft.blocks.petrifiedwood.Petrified_Bark;
import pixilaregames.thrivecraft.blocks.petrifiedwood.Petrified_Button;
import pixilaregames.thrivecraft.blocks.petrifiedwood.Petrified_Door;
import pixilaregames.thrivecraft.blocks.petrifiedwood.Petrified_Fence;
import pixilaregames.thrivecraft.blocks.petrifiedwood.Petrified_Fence_Gate;
import pixilaregames.thrivecraft.blocks.petrifiedwood.Petrified_Leaves;
import pixilaregames.thrivecraft.blocks.petrifiedwood.Petrified_Log;
import pixilaregames.thrivecraft.blocks.petrifiedwood.Petrified_Planks;
import pixilaregames.thrivecraft.blocks.petrifiedwood.Petrified_Pressure_Plate;
import pixilaregames.thrivecraft.blocks.petrifiedwood.Petrified_Sapling;
import pixilaregames.thrivecraft.blocks.petrifiedwood.Petrified_Slab;
import pixilaregames.thrivecraft.blocks.petrifiedwood.Petrified_Stairs;
import pixilaregames.thrivecraft.blocks.petrifiedwood.Petrified_Trapdoor;
import pixilaregames.thrivecraft.blocks.petrifiedwood.Stripped_Petrified_Bark;
import pixilaregames.thrivecraft.blocks.petrifiedwood.Stripped_Petrified_Log;
import pixilaregames.thrivecraft.commands.CmdGamemode;
import pixilaregames.thrivecraft.itemgroups.ThriveCraftItemGroup;
import pixilaregames.thrivecraft.items.base.ItemArmorBase;
import pixilaregames.thrivecraft.items.base.ItemAxeBase;
import pixilaregames.thrivecraft.items.base.ItemHoeBase;
import pixilaregames.thrivecraft.items.base.ItemPickaxeBase;
import pixilaregames.thrivecraft.items.base.ItemShovelBase;
import pixilaregames.thrivecraft.items.base.ItemSwordBase;
import pixilaregames.thrivecraft.items.dracula.Dracula_Fang;
import pixilaregames.thrivecraft.items.dracula.Dracula_Membrane;
import pixilaregames.thrivecraft.items.dracula.Dracula_Wing;
import pixilaregames.thrivecraft.items.mobs.spider.Spider_Leg;
import pixilaregames.thrivecraft.items.onyx.Onyx_Gem;
import pixilaregames.thrivecraft.lists.ArmorMaterialList;
import pixilaregames.thrivecraft.lists.BlockList;
import pixilaregames.thrivecraft.lists.ItemList;
import pixilaregames.thrivecraft.lists.ToolMaterialList;

@Mod("thrivecraft")
public class ThriveCraft
{
	
	public static ThriveCraft instance;
	public static final String modid = "thrivecraft";
	private static final Logger logger = LogManager.getLogger(modid);
	
	public static final ItemGroup thrivecraft = new ThriveCraftItemGroup();
	
	public ThriveCraft()
	{
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegisteries);
		
		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.addListener(this::serverStarting);
	}
	
	private void setup(final FMLCommonSetupEvent event)
	{
		logger.info("Setup method registered");
	}
	
	private void clientRegisteries(final FMLClientSetupEvent event)
	{
		logger.info("Client registeries method registered");
	}
	
	public void enqueueIMC(final InterModEnqueueEvent evnet)
	{
		InterModComms.sendTo("pixelcore", "Hello World", () -> {logger.info("Hello from ThriveCraft"); return "Hello Worlds";});
	}
	
	public void processIMC(final InterModProcessEvent event)
	{
		logger.info("Got IMC {}", event.getIMCStream().map(m->m.getMessageSupplier().get()).collect(Collectors.toList()));
	}
	
	public void serverStarting(FMLServerStartingEvent evt)
	{
		final CommandDispatcher<CommandSource> dp = evt.getCommandDispatcher();
		CmdGamemode.register(dp);
	}
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegsitryEvents
	{
		
		@SubscribeEvent
		public static void registerItems(final Register<Item> event)
		{
			
			event.getRegistry().registerAll
			(
					//Onyx Stuff
					//Items
					ItemList.onyx_gem = new Onyx_Gem(new Item.Properties().group(thrivecraft)).setRegistryName(location("onyx_gem")),
					//Tools
					ItemList.onyx_sword = new ItemSwordBase(ToolMaterialList.onyx, 0, 6.0f, new Item.Properties().group(thrivecraft)).setRegistryName(location("onyx_sword")),
					ItemList.onyx_axe = new ItemAxeBase(ToolMaterialList.onyx, -1.0f, 6.0f, new Item.Properties().group(thrivecraft)).setRegistryName(location("onyx_axe")),
					ItemList.onyx_pickaxe = new ItemPickaxeBase(ToolMaterialList.onyx, -2, 6.0f, new Item.Properties().group(thrivecraft)).setRegistryName(location("onyx_pickaxe")),
					ItemList.onyx_shovel = new ItemShovelBase(ToolMaterialList.onyx, -1.0f, 6.0f, new Item.Properties().group(thrivecraft)).setRegistryName(location("onyx_shovel")),
					ItemList.onyx_hoe = new ItemHoeBase(ToolMaterialList.onyx, 6.0f, new Item.Properties().group(thrivecraft)).setRegistryName(location("onyx_hoe")),
					//Armor
					ItemList.onyx_helmet = new ItemArmorBase(ArmorMaterialList.Onyx, EntityEquipmentSlot.HEAD, new Item.Properties().group(thrivecraft)).setRegistryName(location("onyx_helmet")),
					ItemList.onyx_chestplate = new ItemArmorBase(ArmorMaterialList.Onyx, EntityEquipmentSlot.CHEST, new Item.Properties().group(thrivecraft)).setRegistryName(location("onyx_chestplate")),
					ItemList.onyx_leggings = new ItemArmorBase(ArmorMaterialList.Onyx, EntityEquipmentSlot.LEGS, new Item.Properties().group(thrivecraft)).setRegistryName(location("onyx_leggings")),
					ItemList.onyx_boots = new ItemArmorBase(ArmorMaterialList.Onyx, EntityEquipmentSlot.FEET, new Item.Properties().group(thrivecraft)).setRegistryName(location("onyx_boots")),
					//Blocks
					ItemList.onyx_block = new ItemBlock(BlockList.onyx_block, new Item.Properties().group(thrivecraft)).setRegistryName(BlockList.onyx_block.getRegistryName()),
					ItemList.onyx_ore = new ItemBlock(BlockList.onyx_ore, new Item.Properties().group(thrivecraft)).setRegistryName(BlockList.onyx_ore.getRegistryName()),
					
					//Petrified Cave Mob Stuff
					//Dracula Stuff
					//Items
					ItemList.dracula_fang = new Dracula_Fang(new Item.Properties().group(thrivecraft)).setRegistryName(location("dracula_fang")),
					ItemList.dracula_membrane = new Dracula_Membrane(new Item.Properties().group(thrivecraft)).setRegistryName(location("dracula_membrane")),
					ItemList.dracula_wing = new Dracula_Wing(new Item.Properties().group(thrivecraft)).setRegistryName(location("dracula_wing")),
					//Tools
					ItemList.toothy_sword = new ItemSwordBase(ToolMaterialList.toothy, 0, 6.0f, new Item.Properties().group(thrivecraft)).setRegistryName(location("toothy_sword")),
					ItemList.toothy_axe = new ItemAxeBase(ToolMaterialList.toothy, -1.0f, 6.0f, new Item.Properties().group(thrivecraft)).setRegistryName(location("toothy_axe")),
					ItemList.toothy_pickaxe = new ItemPickaxeBase(ToolMaterialList.toothy, -2, 6.0f, new Item.Properties().group(thrivecraft)).setRegistryName(location("toothy_pickaxe")),
					ItemList.toothy_shovel = new ItemShovelBase(ToolMaterialList.toothy, -1.0f, 6.0f, new Item.Properties().group(thrivecraft)).setRegistryName(location("toothy_shovel")),
					ItemList.toothry_hoe = new ItemHoeBase(ToolMaterialList.toothy, 6.0f, new Item.Properties().group(thrivecraft)).setRegistryName(location("toothy_hoe")),
					//Armor
					ItemList.dracula_elytra = new Item(new Item.Properties().group(thrivecraft)).setRegistryName(location("dracula_elytra")),
					ItemList.toothy_cap = new ItemArmorBase(ArmorMaterialList.Toothy, EntityEquipmentSlot.HEAD, new Item.Properties().group(thrivecraft)).setRegistryName(location("toothy_cap")),
					ItemList.toothy_chestplate = new ItemArmorBase(ArmorMaterialList.Toothy, EntityEquipmentSlot.CHEST, new Item.Properties().group(thrivecraft)).setRegistryName(location("toothy_chestplate")),
					ItemList.toothy_pants = new ItemArmorBase(ArmorMaterialList.Toothy, EntityEquipmentSlot.LEGS, new Item.Properties().group(thrivecraft)).setRegistryName(location("toothy_pants")),
					ItemList.toothy_boots = new ItemArmorBase(ArmorMaterialList.Toothy, EntityEquipmentSlot.FEET, new Item.Properties().group(thrivecraft)).setRegistryName(location("toothy_boots")),
					//Spider Stuff
					//Items
					ItemList.spider_leg = new Spider_Leg(new Item.Properties().group(thrivecraft)).setRegistryName(location("spider_leg")),
					
					//Petrified Wood Stuff
					//Blocks
					ItemList.stripped_petrified_log = new ItemBlock(BlockList.stripped_petrified_log, new Item.Properties().group(thrivecraft)).setRegistryName(BlockList.stripped_petrified_log.getRegistryName()),
					ItemList.stripped_petrified_bark = new ItemBlock(BlockList.stripped_petrified_bark, new Item.Properties().group(thrivecraft)).setRegistryName(BlockList.stripped_petrified_bark.getRegistryName()),
					ItemList.petrified_log = new ItemBlock(BlockList.petrified_log, new Item.Properties().group(thrivecraft)).setRegistryName(BlockList.petrified_log.getRegistryName()),
					ItemList.petrified_bark = new ItemBlock(BlockList.petrified_bark, new Item.Properties().group(thrivecraft)).setRegistryName(BlockList.petrified_bark.getRegistryName()),
					ItemList.petrified_planks = new ItemBlock(BlockList.petrified_planks, new Item.Properties().group(thrivecraft)).setRegistryName(BlockList.petrified_planks.getRegistryName()),
					ItemList.petrified_sapling = new ItemBlock(BlockList.petrified_sapling, new Item.Properties().group(thrivecraft)).setRegistryName(BlockList.petrified_sapling.getRegistryName()),
					ItemList.petrified_door = new ItemBlock(BlockList.petrified_door, new Item.Properties().group(thrivecraft)).setRegistryName(BlockList.petrified_door.getRegistryName()),
					ItemList.petrified_slab = new ItemBlock(BlockList.petrified_slab, new Item.Properties().group(thrivecraft)).setRegistryName(BlockList.petrified_slab.getRegistryName()),
					ItemList.petrified_stairs = new ItemBlock(BlockList.petrified_stairs, new Item.Properties().group(thrivecraft)).setRegistryName(BlockList.petrified_stairs.getRegistryName()),
					ItemList.petrified_leaves = new ItemBlock(BlockList.petrified_leaves, new Item.Properties().group(thrivecraft)).setRegistryName(BlockList.petrified_leaves.getRegistryName()),
					ItemList.petrified_fence = new ItemBlock(BlockList.petrified_fence, new Item.Properties().group(thrivecraft)).setRegistryName(BlockList.petrified_fence.getRegistryName()),
					ItemList.petrified_fence_gate = new ItemBlock(BlockList.petrified_fence_gate, new Item.Properties().group(thrivecraft)).setRegistryName(BlockList.petrified_fence_gate.getRegistryName()),
					ItemList.petrified_trapdoor = new ItemBlock(BlockList.petrified_trapdoor, new Item.Properties().group(thrivecraft)).setRegistryName(BlockList.petrified_trapdoor.getRegistryName()),
					ItemList.petrified_pressure_plate = new ItemBlock(BlockList.petrified_pressure_plate, new Item.Properties().group(thrivecraft)).setRegistryName(BlockList.petrified_pressure_plate.getRegistryName()),
					ItemList.petrified_button = new ItemBlock(BlockList.petrified_button, new Item.Properties().group(thrivecraft)).setRegistryName(BlockList.petrified_button.getRegistryName())
			);
			
			logger.info("Items Registered");
		}
		@SubscribeEvent
		public static void registerBlockss(final Register<Block> event)
		{
			event.getRegistry().registerAll
			(
					//Onyx Blocks
					BlockList.onyx_block = new Onyx_Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 15.0f).lightValue(0).sound(SoundType.METAL)).setRegistryName(location("onyx_block")),
					BlockList.onyx_ore = new Onyx_Ore(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 15.0f).lightValue(0).sound(SoundType.STONE)).setRegistryName(location("onyx_ore")),
					
					//Petrified Wood Blocks
					BlockList.stripped_petrified_log = new Stripped_Petrified_Log(MaterialColor.ADOBE, Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0f, 10.0f).lightValue(0).sound(SoundType.WOOD)).setRegistryName(location("stripped_petrified_log")),
					BlockList.stripped_petrified_bark = new Stripped_Petrified_Bark(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0f, 10.0f).lightValue(0).sound(SoundType.WOOD)).setRegistryName(location("stripped_petrified_bark")),
					BlockList.petrified_log = new Petrified_Log(MaterialColor.ADOBE, Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0f, 10.0f).lightValue(0).sound(SoundType.WOOD)).setRegistryName(location("petrified_log")),
					BlockList.petrified_bark = new Petrified_Bark(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0f, 10.0f).lightValue(0).sound(SoundType.WOOD)).setRegistryName(location("petrified_bark")),
					BlockList.petrified_planks = new Petrified_Planks(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0f, 10.0f).lightValue(0).sound(SoundType.WOOD)).setRegistryName(location("petrified_planks")),
					BlockList.petrified_sapling = new Petrified_Sapling(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0f, 1.0f).lightValue(0).sound(SoundType.PLANT)).setRegistryName(location("petrified_sapling")),
					BlockList.petrified_door = new Petrified_Door(Properties.create(Material.WOOD).hardnessAndResistance(2.0f, 10.0f).variableOpacity().sound(SoundType.WOOD)).setRegistryName(location("petrified_door")),
					BlockList.petrified_slab = new Petrified_Slab(Properties.create(Material.WOOD).hardnessAndResistance(2.0f, 10.0f).variableOpacity().sound(SoundType.WOOD)).setRegistryName(location("petrified_slab")),
					BlockList.petrified_stairs = new Petrified_Stairs(BlockList.petrified_planks.getDefaultState(), Block.Properties.from(BlockList.petrified_planks)).setRegistryName(location("petrified_stairs")),
					BlockList.petrified_leaves = new Petrified_Leaves(Properties.create(Material.LEAVES).hardnessAndResistance(1.0f, 1.0f).lightValue(0).sound(SoundType.PLANT)).setRegistryName(location("petrified_leaves")),
					BlockList.petrified_fence = new Petrified_Fence(Properties.create(Material.WOOD).hardnessAndResistance(2.0f, 10.0f).lightValue(0).sound(SoundType.WOOD)).setRegistryName(location("petrified_fence")),
					BlockList.petrified_fence_gate = new Petrified_Fence_Gate(Properties.create(Material.WOOD).hardnessAndResistance(2.0f, 10.0f).lightValue(0).sound(SoundType.WOOD)).setRegistryName(location("petrified_fence_gate")),
					BlockList.petrified_trapdoor = new Petrified_Trapdoor(Properties.create(Material.WOOD).hardnessAndResistance(2.0f, 10.0f).lightValue(0).sound(SoundType.WOOD)).setRegistryName(location("petrified_trapdoor")),
					BlockList.petrified_pressure_plate = new Petrified_Pressure_Plate(Petrified_Pressure_Plate.Sensitivity.EVERYTHING,Properties.create(Material.WOOD).hardnessAndResistance(2.0f, 10.0f).lightValue(0).sound(SoundType.WOOD)).setRegistryName(location("petrified_pressure_plate")),
					BlockList.petrified_button = new Petrified_Button(Properties.create(Material.WOOD).hardnessAndResistance(2.0f, 10.0f).lightValue(0).sound(SoundType.WOOD)).setRegistryName(location("petrified_button"))
			);
			
			logger.info("Blocks Registered");
		}
		
		private static ResourceLocation location(String name)
		{
			return new ResourceLocation(modid, name);
		}
		
	}
}
