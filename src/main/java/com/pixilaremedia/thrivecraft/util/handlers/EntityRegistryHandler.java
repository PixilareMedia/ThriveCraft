package com.pixilaremedia.thrivecraft.util.handlers;

import com.google.common.base.Preconditions;
import com.pixilaremedia.thrivecraft.Ref;
import com.pixilaremedia.thrivecraft.entity.BlackWidowEntity;
import com.pixilaremedia.thrivecraft.init.EntityInit;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

//@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityRegistryHandler
{
    /*@SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityType<?>> event)
    {
        SpawnPlacements.register(EntityInit.BLACK_WIDOW.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BlackWidowEntity::canBlackWidowSpawn);
    }
    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event)
    {
        event.put(EntityInit.BLACK_WIDOW.get(), BlackWidowEntity.createAttributes().build());
    }
    @SubscribeEvent
    public static void registerSpawnEggs(RegistryEvent.Register<Item> event)
    {
        for (Item spawnEgg : EntityInit.SPAWN_EGGS)
        {
            Preconditions.checkNotNull(spawnEgg.getRegistryName(), "registryName");
            event.getRegistry().register(spawnEgg);
        }
    }
    /*@SubscribeEvent
    public static void onEntityRegistry(final RegistryEvent.Register<EntityType<?>> event)
    {
        event.getRegistry().registerAll(
                //EntitiesList.BLACKWIDOW
        );
        Ref.LOGGER.info("Finished Registering All Entities");
    }*/
}
