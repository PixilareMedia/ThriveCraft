package com.pixilaremedia.thrivecraft.worldgen;

import com.pixilaremedia.pixelcore.util.helpers.WorldGenHelper;
import com.pixilaremedia.pixelcore.util.helpers.ConfigHelper;
import com.pixilaremedia.thrivecraft.config.ConfigOptions;
import com.pixilaremedia.thrivecraft.init.BlockInit;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Map;

public class WorldGen
{
    public static void checkWorldGenConfig()
    {
        if(ConfigHelper.booleanTest(ConfigOptions.onyxOreEnabled)) WorldGenHelper.registerFeature(BlockInit.ONYX_ORE.get(), OreConfiguration.Predicates.NATURAL_STONE, ConfigHelper.intTest(ConfigOptions.onyxMaxVeinSize), ConfigHelper.intTest(ConfigOptions.onyxMaxY), ConfigHelper.intTest(ConfigOptions.onyxMinY), ConfigHelper.intTest(ConfigOptions.onyxPerChunk));
        WorldGen.setupGen();
    }

    public static void setupGen()
    {
        for(Map.Entry<ResourceKey<Biome>, Biome> biome : ForgeRegistries.BIOMES.getEntries())
        {
            if(!biome.getValue().getBiomeCategory().equals(Biome.BiomeCategory.NETHER) && !biome.getValue().getBiomeCategory().equals(Biome.BiomeCategory.THEEND))
            {
                WorldGenHelper.addFeatureToBiome(biome.getValue(), GenerationStep.Decoration.UNDERGROUND_ORES, BuiltinRegistries.CONFIGURED_FEATURE.get(BlockInit.ONYX_ORE.get().getRegistryName()));
            }
        }
    }
}
