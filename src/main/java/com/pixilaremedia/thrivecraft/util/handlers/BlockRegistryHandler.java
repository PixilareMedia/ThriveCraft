package com.pixilaremedia.thrivecraft.util.handlers;

import com.pixilaremedia.pixelcore.References;
import com.pixilaremedia.thrivecraft.Ref;
import com.pixilaremedia.thrivecraft.init.BlockInit;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fmllegacy.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockRegistryHandler
{
    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event)
    {
        BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            event.getRegistry().register(new BlockItem(block, new Item.Properties().tab(Ref.TRIVECRAFT_TAB)).setRegistryName(block.getRegistryName()));
        });
        References.LOGGER.info("Registered all the blocks into item blocks,");
    }
}
