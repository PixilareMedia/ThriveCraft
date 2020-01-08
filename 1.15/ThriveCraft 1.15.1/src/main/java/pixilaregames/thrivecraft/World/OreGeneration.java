package pixilaregames.thrivecraft.World;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.Block;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;
import pixilaregames.thrivecraft.Config.ConfigOptions;
import pixilaregames.thrivecraft.Lists.BlockList;

public class OreGeneration
{
	public static void setupWorldGeneration()
	{
		for(BiomeManager.BiomeType type : BiomeManager.BiomeType.values())
		{
			ImmutableList<BiomeEntry> biomes = BiomeManager.getBiomes(type);
			if(biomes != null)
			{
				for(BiomeManager.BiomeEntry entry : biomes)
				{
					addGeneration(entry.biome);
				}
			}
		}
	}
	
	private static void addGeneration(Biome biome)
	{
		addOreGeneration(biome, BlockList.onyx_ore, ConfigOptions.onyxPerChunk, ConfigOptions.onyxMaxVeinSize, 0, 0, 60);
	}
	
	private static void addOreGeneration(Biome biome, Block blockProvider, IntValue maxVeinSize, IntValue veinsPerChunk, int minHeight, int topOffset, int maxHeight)
	{
		biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, blockProvider.getBlock().getBlock().getDefaultState(), maxVeinSize.get())).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(veinsPerChunk.get(), minHeight, topOffset, maxHeight))));
	}
}
