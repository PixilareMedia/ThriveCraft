package com.pixilaremedia.thrivecraft.util.handlers;

import com.pixilaremedia.pixelcore.References;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PostRegistryHandler
{
    @SubscribeEvent
    public static void postSet(FMLLoadCompleteEvent event)
    {
        References.PIXEL_CORE_INSTALLED = References.modsList("pixelcore");
        References.ORESPAWN_RENEWED_INSTALLED = References.modsList("orespawn_renewed");
        References.DECORATION_BLOCKS_INSTALLED = References.modsList("decorationblocks");
        References.NEW_MINECRAFT_STUFF_INSTALLED = References.modsList("newminecraftstuff");
    }
}
