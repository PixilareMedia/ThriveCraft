package pixilaregames.thrivecraft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import pixilaregames.thrivecraft.lists.BlockList;
import pixilaregames.thrivecraft.lists.ItemList;

@Mod("thrivecraft")
public class ThriveCraft
{
	
	public static ThriveCraft instance;
	public static final String modid = "thrivecraft";
	private static final Logger logger = LogManager.getLogger(modid);
	
	public ThriveCraft()
	{
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegisteries);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event)
	{
		logger.info("Setup method registered");
	}
	
	private void clientRegisteries(final FMLClientSetupEvent event)
	{
		logger.info("Client registeries method registered");
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
					ItemList.onyx_gem = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("onyx_gem")),
					ItemList.onyx_sword = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("onyx_sword")),
					ItemList.onyx_axe = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("onyx_axe")),
					ItemList.onyx_pickaxe = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("onyx_pickaxe")),
					ItemList.onyx_shovel = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("onyx_shovel")),
					ItemList.onyx_hoe = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("onyx_hoe")),
					ItemList.onyx_helmet = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("onyx_helmet")),
					ItemList.onyx_chestplate = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("onyx_chestplate")),
					ItemList.onyx_leggings = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("onyx_leggings")),
					ItemList.onyx_boots = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("onyx_boots")),
					//Blocks
					ItemList.onyx_block = new ItemBlock(BlockList.onyx_block, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(BlockList.onyx_block.getRegistryName()),
					ItemList.onyx_ore = new ItemBlock(BlockList.onyx_ore, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(BlockList.onyx_ore.getRegistryName()),
					
					//Petrified Stuff
					//Blocks
					ItemList.stripped_petrified_log = new ItemBlock(BlockList.stripped_petrified_log, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(BlockList.stripped_petrified_log.getRegistryName()),
					ItemList.stripped_petrified_bark = new ItemBlock(BlockList.stripped_petrified_bark, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(BlockList.stripped_petrified_bark.getRegistryName()),
					ItemList.petrified_log = new ItemBlock(BlockList.petrified_log, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(BlockList.petrified_log.getRegistryName()),
					ItemList.petrified_bark = new ItemBlock(BlockList.petrified_bark, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(BlockList.petrified_bark.getRegistryName()),
					ItemList.petrified_planks = new ItemBlock(BlockList.petrified_planks, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(BlockList.petrified_planks.getRegistryName())
			);
			
			logger.info("Items Registered");
		}
		@SubscribeEvent
		public static void registerBlockss(final Register<Block> event)
		{
			event.getRegistry().registerAll
			(
					//Onyx Blocks
					BlockList.onyx_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 15.0f).lightValue(0).sound(SoundType.METAL)).setRegistryName(location("onyx_block")),
					BlockList.onyx_ore = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 15.0f).lightValue(0).sound(SoundType.STONE)).setRegistryName(location("onyx_ore")),
					
					//Petrified Blocks
					BlockList.stripped_petrified_log = new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0f, 10.0f).lightValue(0).sound(SoundType.WOOD)).setRegistryName(location("stripped_petrified_log")),
					BlockList.stripped_petrified_bark = new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0f, 10.0f).lightValue(0).sound(SoundType.WOOD)).setRegistryName(location("stripped_petrified_bark")),
					BlockList.petrified_log = new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0f, 10.0f).lightValue(0).sound(SoundType.WOOD)).setRegistryName(location("petrified_log")),
					BlockList.petrified_bark = new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0f, 10.0f).lightValue(0).sound(SoundType.WOOD)).setRegistryName(location("petrified_bark")),
					BlockList.petrified_planks = new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0f, 10.0f).lightValue(0).sound(SoundType.WOOD)).setRegistryName(location("petrified_planks"))
			);
			
			logger.info("Blocks Registered");
		}
		
		private static ResourceLocation location(String name)
		{
			return new ResourceLocation(modid, name);
		}
	}
}
