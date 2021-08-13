package com.pixilaremedia.thrivecraft;

import com.pixilaremedia.pixelcore.References;
import com.pixilaremedia.thrivecraft.config.Config;
import com.pixilaremedia.thrivecraft.init.*;
import com.pixilaremedia.thrivecraft.worldgen.WorldGen;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod("thrivecraft")
@Mod.EventBusSubscriber(modid = Ref.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Main
{
    public Main()
    {
        Ref.INSTANCE = this;

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.server_config, Ref.CONFIG_FILE);

        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        SoundInit.SOUNDS.register(bus);
        //EntityInit.ENTITY_DEFERRED.register(bus);

        bus.addListener(this::commonSetup);
        bus.addListener(this::enqueueIMC);
        bus.addListener(this::processIMC);
        bus.addListener(this::clientRegisteries);

        Config.loadConfig(Config.server_config, FMLPaths.CONFIGDIR.get().resolve(Ref.CONFIG_FILE).toString());

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        WorldGen.checkWorldGenConfig();
        References.LOGGER.info("Setup method registered");
    }

    private void clientRegisteries(final FMLClientSetupEvent event)
    {
        //RnederRegistry.registryEntityRenders();
        References.LOGGER.info("Client registeries method registered");
    }

    private void enqueueIMC(final InterModEnqueueEvent event) { }

    private void processIMC(final InterModProcessEvent event) { }
}
