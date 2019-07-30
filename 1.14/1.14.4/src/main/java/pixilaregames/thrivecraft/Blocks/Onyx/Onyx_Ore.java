package pixilaregames.thrivecraft.Blocks.Onyx;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import pixilaregames.pixelcore.API.BlocksBase.BlockOreBase;
import pixilaregames.thrivecraft.Lists.ItemList;

public class Onyx_Ore extends BlockOreBase
{
	public Onyx_Ore(Properties builder) {
		super(builder);
	}
	
	public IItemProvider getItemDropped(BlockState state, World worldIn, BlockPos pos, int fortune)
	{
		return ItemList.onyx_gem;
	}
	
	public int getItemsToDropCount(BlockState state, int fortune, World worldIn, BlockPos pos, Random random)
	{
		if(fortune > 0 && this != this.getItemDropped(this.getStateContainer().getValidStates().iterator().next(), worldIn, pos, fortune))
		{
			int i = random.nextInt(fortune + 2) - 1;
			if (i < 0)
			{
				i = 0;
			}
			return this.quantityDropped(state, random) * (i + 1);
		} else {
			return this.quantityDropped(state, random);
		}
	}

	private int quantityDropped(BlockState state, Random random)
	{
		return 0;
	}
}
