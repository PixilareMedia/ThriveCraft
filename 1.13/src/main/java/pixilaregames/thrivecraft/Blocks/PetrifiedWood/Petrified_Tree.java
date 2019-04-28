package pixilaregames.thrivecraft.Blocks.PetrifiedWood;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.trees.AbstractTree;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.BigTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeature;

@SuppressWarnings("unused")
public class Petrified_Tree extends AbstractTree
{
	@Nullable
	protected AbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random)
	{
		return (AbstractTreeFeature<NoFeatureConfig>)(random.nextInt(10) == 0 ? new BigTreeFeature(true) : new Petrified_Tree_Feature(true));
	}
}
