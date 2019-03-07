package pixilaregames.thrivecraft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
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
					ItemList.onyx_gem = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("onyx_gem")),
					ItemList.onyx_sword = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("onyx_sword")),
					ItemList.onyx_axe = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("onyx_axe")),
					ItemList.onyx_pickaxe = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("onyx_pickaxe")),
					ItemList.onyx_shovel = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("onyx_shovel")),
					ItemList.onyx_hoe = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("onyx_hoe")),
					ItemList.onyx_helmet = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("onyx_helmet")),
					ItemList.onyx_chestplate = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("onyx_chestplate")),
					ItemList.onyx_leggings = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("onyx_leggings")),
					ItemList.onyx_boots = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("onyx_boots"))
			);
			
			logger.info("Items Registered");
		}
		
		private static ResourceLocation location(String name)
		{
			return new ResourceLocation(modid, name);
		}
	}
}
