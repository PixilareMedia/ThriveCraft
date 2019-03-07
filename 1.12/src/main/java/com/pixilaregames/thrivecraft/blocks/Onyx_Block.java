package com.pixilaregames.thrivecraft.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

import com.pixilaregames.thrivecraft.Main;

public class Onyx_Block extends BlockBase
{
	public Onyx_Block(String name, Material material) 
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
}
