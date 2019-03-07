package com.pixilaregames.thrivecraft.blocks;

import com.pixilaregames.thrivecraft.Main;
import com.pixilaregames.thrivecraft.blocks.tileentity.TileEntityPetrifiedChest;
import com.pixilaregames.thrivecraft.init.ModBlocks;
import com.pixilaregames.thrivecraft.init.ModItems;
import com.pixilaregames.thrivecraft.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Petrified_Chest extends BlockContainer {

	public Petrified_Chest(String name)
	{
		super(Material.WOOD);
		setUnlocalizedName(name);
		setRegistryName(name);
		setSoundType(SoundType.WOOD);
		setHardness(2.0F);
		setResistance(10.0F);
		setHarvestLevel("axe", 0);
		setCreativeTab(Main.tabThriveCraft);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(name));
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if(worldIn.isRemote)
		{
			playerIn.openGui(Main.instance, Reference.GUI_PETRIFIED_CHEST, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
	{
		TileEntityPetrifiedChest tileentity = (TileEntityPetrifiedChest)worldIn.getTileEntity(pos);
		InventoryHelper.dropInventoryItems(worldIn, pos, tileentity);
		super.breakBlock(worldIn, pos, state);
	}
	
	 @Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
	{
		 if(stack.hasDisplayName())
		 {
			 TileEntity tileentity = worldIn.getTileEntity(pos);
			 
			 if(tileentity instanceof TileEntityPetrifiedChest)
			 {
				 ((TileEntityPetrifiedChest)tileentity).setCustomName(stack.getDisplayName());
			 }
		 }
	}
	 
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		return new TileEntityPetrifiedChest();
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state)
	{
		return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
	}
	
	@Override
	public boolean isFullBlock(IBlockState state)
	{
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}
}
