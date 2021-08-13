package com.pixilaremedia.thrivecraft.init;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.pixilaremedia.thrivecraft.Ref;
import com.pixilaremedia.thrivecraft.entity.BlackWidowEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityInit
{
    /*public static final DeferredRegister<EntityType<?>> ENTITY_DEFERRED = DeferredRegister.create(ForgeRegistries.ENTITIES, Ref.MODID);
    public static final List<Item> SPAWN_EGGS = Lists.newArrayList();

    public static final RegistryObject<EntityType<BlackWidowEntity>> BLACK_WIDOW = createMonsterEntity("black_widow", BlackWidowEntity::new, 0.6F, 0.9F, 8, 0x1b1e24, 0x1b3975);

    private static <T extends Monster> RegistryObject<EntityType<T>> createMonsterEntity(String name, EntityType.EntityFactory<T> factory, float width, float height, int trackingRange, int eggPrimary, int eggSecondary)
    {
        EntityType<T> entity = EntityType.Builder.of(factory, MobCategory.MONSTER).sized(width, height).setTrackingRange(trackingRange).setUpdateInterval(1).build(Ref.location(name).toString());
        Item spawnEgg = new SpawnEggItem(entity, eggPrimary, eggSecondary, (new Item.Properties()).tab(Ref.TRIVECRAFT_TAB));
        SPAWN_EGGS.add(spawnEgg);

        return ENTITY_DEFERRED.register(name, () -> entity);
    }*/

    /*@SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityType<?>> event)
    {
        SpawnPlacements.register(BLACK_WIDOW.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BlackWidowEntity::canBlackWidowSpawn);
    }
    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event)
    {
        event.put(BLACK_WIDOW.get(), BlackWidowEntity.createAttributes().build());
    }
    @SubscribeEvent
    public static void registerSpawnEggs(RegistryEvent.Register<Item> event)
    {
        for (Item spawnEgg : SPAWN_EGGS)
        {
            Preconditions.checkNotNull(spawnEgg.getRegistryName(), "registryName");
            event.getRegistry().register(spawnEgg);
        }
    }*/

    /*public static EntityType<BlackWidow> BLACKWIDOW = register("black_widow", EntityType.Builder.<~>of(BlackWidow::new, MobCategory.MONSTER).sized(0.6F, 0.9F).clientTrackingRange(8));

    private static <T extends Entity> EntityType<T> register(String name, EntityType.Builder<T> builder) {
        return Registry.register(Registry.ENTITY_TYPE, name, builder.build(name));
    }

    public static void registerEntitySpawnEggs(final RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(
                ItemList.ENTITY_EGG = registerEntitySpawnEgg(BLACKWIDOW, 0x1b1e24, 0x1b3975, "black_widdow_spawn_egg")
        );
    }

    public static void registerEntityWorldSpawns()
    {
        //registerEntityWorldSpawn(BLACKWIDOW, Biomes.PLAINS);
    }

    private static Item registerEntitySpawnEgg(EntityType<?> type, int colour1, int colour2, String name)
    {
        SpawnEggItem item = new SpawnEggItem(type, colour1, colour2, new Item.Properties().tab(Ref.thrivecraft));
        item.setRegistryName(Ref.location(name));
        return item;
    }

    private static void registerEntityWorldSpawn(EntityType<?> entity, Biome... biomes)
    {
        for (Biome biome : biomes)
        {
            if(biome !=null)
            {
                //biome.getSpawns(entity.getCategory()).add(new SpawnListEntry(entity, 10, 1, 10));
            }
        }
    }*/
}
