package com.pixilaregames.thrivecraft.blocks;

import java.util.Random;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import com.pixilaregames.thrivecraft.Main;
import com.pixilaregames.thrivecraft.init.ModItems;

public class Onyx_Ore extends BlockBase
{
	public Onyx_Ore(String name, Material material) 
	{
		super(name, material);
		setSoundType(SoundType.STONE);
		setHardness(5.0F);
		setResistance(15.0F);
		setHarvestLevel("pickaxe", 3);
		//setLightLevel(1.0F);
		//setLightOpacity(1);
		//setBlockUnbreakable();
		setCreativeTab(Main.tabThriveCraft);
	}
	
	@Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return ModItems.ONYX;
    }
	
	@Override
    public int quantityDropped(Random random)
    {
        return 1;
    }
}
