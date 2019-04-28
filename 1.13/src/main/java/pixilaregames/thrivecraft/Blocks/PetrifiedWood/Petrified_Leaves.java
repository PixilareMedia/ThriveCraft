package pixilaregames.thrivecraft.Blocks.PetrifiedWood;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import pixilaregames.pixelcore.API.BlocksBase.BlockLeavesBase;
import pixilaregames.thrivecraft.Lists.BlockList;

public class Petrified_Leaves extends BlockLeavesBase implements IShearable
{
	public static final IntegerProperty DISTANCE = BlockStateProperties.DISTANCE_1_7;
	public static final BooleanProperty PERSISTENT = BlockStateProperties.PERSISTENT;
	protected static boolean renderTranslucent;

	/*public Petrified_Leaves(Properties builder)
	{
		super(builder);
	}*/
	public Petrified_Leaves(Block.Properties builder)
	{
		super(builder);
		this.setDefaultState(this.stateContainer.getBaseState().with(DISTANCE, Integer.valueOf(7)).with(PERSISTENT, Boolean.valueOf(false)));
	}
	
	public IItemProvider getItemDropped(IBlockState state, World worldIn, BlockPos pos, int fortune) {
		Block block = state.getBlock();
	    if (block == BlockList.petrified_leaves) {
	    	return BlockList.petrified_sapling;
	    }
		return block == Blocks.DARK_OAK_LEAVES ? Blocks.DARK_OAK_SAPLING : Blocks.OAK_SAPLING;
	}
}
