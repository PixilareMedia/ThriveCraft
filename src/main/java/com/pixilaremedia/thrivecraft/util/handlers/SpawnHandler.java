package com.pixilaremedia.thrivecraft.util.handlers;

import com.pixilaremedia.thrivecraft.Ref;
import com.pixilaremedia.thrivecraft.config.ConfigOptions;
import com.pixilaremedia.thrivecraft.init.EntityInit;
import com.pixilaremedia.thrivecraft.util.helpers.BiomeDictionaryHelper;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

//@Mod.EventBusSubscriber(modid = Ref.MODID)
public class SpawnHandler
{
    /*@SubscribeEvent(priority = EventPriority.HIGH)
    public static void addSpawn(BiomeLoadingEvent event) {
        if (event.getName() != null) {
            Biome biome = ForgeRegistries.BIOMES.getValue(event.getName());
            if (biome != null) {
                ResourceKey<Biome> resourceKey = ResourceKey.create(ForgeRegistries.Keys.BIOMES, event.getName());
                List<BiomeDictionary.Type> includeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(ConfigOptions.blackWidowSpawnInclude.get()));
                List<BiomeDictionary.Type> excludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(ConfigOptions.blackWidowSpawnExclude.get()));
                if (!includeList.isEmpty()) {
                    Set<BiomeDictionary.Type> biomeTypes = BiomeDictionary.getTypes(resourceKey);
                    if (biomeTypes.stream().noneMatch(excludeList::contains) && biomeTypes.stream().anyMatch(includeList::contains)) {
                        event.getSpawns().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData(EntityInit.BLACK_WIDOW.get(), ConfigHelper.blackWidowSpawnWeight(), ConfigHelper.blackWidowSpawnMin(), ConfigHelper.blackWidowSpawnMax()));
                    }
                } else {
                    throw new IllegalArgumentException("Do not leave the BiomeDictionary type inclusion list empty. If you wish to disable spawning of an entity, set the weight to 0 instead.");
                }
            }
        }
    }*/
}
