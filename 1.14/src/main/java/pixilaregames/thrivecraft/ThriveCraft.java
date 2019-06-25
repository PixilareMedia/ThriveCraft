package pixilaregames.thrivecraft;

import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import pixilaregames.pixelcore.API.ItemsBase.ItemAxeBase;
import pixilaregames.pixelcore.API.ItemsBase.ItemHoeBase;
import pixilaregames.pixelcore.API.ItemsBase.ItemPickaxeBase;
import pixilaregames.pixelcore.API.ItemsBase.ItemShovelBase;
import pixilaregames.pixelcore.API.ItemsBase.ItemSwordBase;
import pixilaregames.thrivecraft.ItemGroups.ThriveCraftItemGroup;
import pixilaregames.thrivecraft.Items.Onyx.Onyx_Gem;
import pixilaregames.thrivecraft.Lists.ItemList;
import pixilaregames.thrivecraft.Lists.ToolMaterialList;

@Mod("thrivecraft")
public class ThriveCraft
{
	
	public static ThriveCraft instance;
	public static final String modid = "thrivecraft";
	private static final Logger logger = LogManager.getLogger(modid);
	
	public static final ItemGroup thrivecraft = new ThriveCraftItemGroup();
	
	public static boolean pixelcoreinstalled = false;
	
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
	
	public void enqueueIMC(final InterModEnqueueEvent evnet)
	{
		InterModComms.sendTo("pixelcore", "Hello PixelCore How Are You", () -> {logger.info("Hello from ThriveCraft"); return "Hello Worlds";});
	}
	
	public void processIMC(final InterModProcessEvent event)
	{
		logger.info("Got IMC {}", event.getIMCStream().map(m->m.getMessageSupplier().get()).collect(Collectors.toList()));
	}
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegsitryEvents
	{
		
		@SubscribeEvent
		public static void registerItems(final Register<Item> event)
		{
			
			event.getRegistry().registerAll
			(
					//put items here
					//Onyx Stuff
					//Items
					ItemList.onyx_gem = new Onyx_Gem(new Item.Properties().group(thrivecraft)).setRegistryName(location("onyx_gem")),
					//Tools
					ItemList.onyx_sword = new ItemSwordBase(ToolMaterialList.onyx, 0, 6.0f, new Item.Properties().group(thrivecraft)).setRegistryName(location("onyx_sword")),
					ItemList.onyx_axe = new ItemAxeBase(ToolMaterialList.onyx, -1.0f, 6.0f, new Item.Properties().group(thrivecraft)).setRegistryName(location("onyx_axe")),
					ItemList.onyx_pickaxe = new ItemPickaxeBase(ToolMaterialList.onyx, -2, 6.0f, new Item.Properties().group(thrivecraft)).setRegistryName(location("onyx_pickaxe")),
					ItemList.onyx_shovel = new ItemShovelBase(ToolMaterialList.onyx, -1.0f, 6.0f, new Item.Properties().group(thrivecraft)).setRegistryName(location("onyx_shovel")),
					ItemList.onyx_hoe = new ItemHoeBase(ToolMaterialList.onyx, 6.0f, new Item.Properties().group(thrivecraft)).setRegistryName(location("onyx_hoe"))
			);
			
			logger.info("Items Registered");
		}
		@SubscribeEvent
		public static void registerBlockss(final Register<Block> event)
		{
			event.getRegistry().registerAll
			(
					//put blocks here
			);
			
			logger.info("Blocks Registered");
		}
		
		private static ResourceLocation location(String name)
		{
			return new ResourceLocation(modid, name);
		}
		
		@SubscribeEvent
		public static void postSet(FMLLoadCompleteEvent event)
		{
			pixelcoreinstalled = ModList.get().isLoaded("pixelcore");
		}
		
	}
}
