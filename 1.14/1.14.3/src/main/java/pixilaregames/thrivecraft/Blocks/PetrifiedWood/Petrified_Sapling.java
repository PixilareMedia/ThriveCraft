package pixilaregames.thrivecraft.Blocks.PetrifiedWood;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class Petrified_Sapling extends BushBlock implements IGrowable
{

	public Petrified_Sapling(Petrified_Tree petrified_Tree, Properties properties)
	{
		super(properties);
	}

	@Override
	public boolean canGrow(IBlockReader arg0, BlockPos arg1, BlockState arg2, boolean arg3)
	{
		return false;
	}

	@Override
	public boolean canUseBonemeal(World arg0, Random arg1, BlockPos arg2, BlockState arg3)
	{
		return false;
	}

	@Override
	public void grow(World arg0, Random arg1, BlockPos arg2, BlockState arg3)
	{
		
	}
}
