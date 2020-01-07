package pixilaregames.thrivecraft.Blocks.PetrifiedWood;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class Petrified_Tree_Feature extends AbstractTreeFeature<NoFeatureConfig>
{

	public Petrified_Tree_Feature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i49920_1_, boolean doBlockNofityOnPlace)
	{
		super(p_i49920_1_, doBlockNofityOnPlace);
	}

	@Override
	protected boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos position, MutableBoundingBox p_208519_5_)
	{
		return false;
	}
}
