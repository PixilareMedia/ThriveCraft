package pixilaregames.thrivecraft.World;

import com.google.common.base.Predicate;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.CompositeFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MinableConfig;
import net.minecraft.world.gen.placement.CountRange;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraftforge.registries.ForgeRegistries;
import pixilaregames.thrivecraft.Lists.BlockList;
import pixilaregames.thrivecraft.World.DimensionalGenerator;

@SuppressWarnings("unused")
public class OreGeneration
{
	private static final Predicate<IBlockState> IS_NETHERRACK = state -> state.getBlock() == Blocks.NETHERRACK;
	private static final Predicate<IBlockState> IS_ENDSTONE = state -> state.getBlock() == Blocks.END_STONE;
	
	public static void setupOreGeneration()
	{
		for(Biome biome : ForgeRegistries.BIOMES)
		{
			CountRangeConfig onyx_ore_placement = new CountRangeConfig(10, 1, 1, 256);
			biome.addFeature(Decoration.UNDERGROUND_ORES, new CompositeFeature<>(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, BlockList.onyx_ore.getDefaultState(), 20), new CountRange(), onyx_ore_placement));

			CountRangeConfig onyx_ore_nether_placement = new CountRangeConfig(10, 1, 1, 256);
			//biome.addFeature(Decoration.UNDERGROUND_ORES, new DimensionalGenerator<>(Feature.MINABLE, new MinableConfig(IS_NETHERRACK, BlockList.onyx_ore.getDefaultState(), 20), new CountRange(), onyx_ore_nether_placement), DimensionType.NETHER);
			
			CountRangeConfig onyx_ore_end_placement = new CountRangeConfig(10, 1, 1, 256);
			//biome.addFeature(Decoration.UNDERGROUND_ORES, new DimensionalGenerator<>(Feature.MINABLE, new MinableConfig(IS_ENDSTONE, BlockList.onyx_ore.getDefaultState(), 20), new CountRange(), onyx_ore_end_placement), DimensionType.THE_END);
		}
	}
	
	
}
