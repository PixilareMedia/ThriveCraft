package com.pixilaregames.thrivecraft.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class Petrified_Planks extends BlockBase
{

	public Petrified_Planks(String name, Material material) 
	{
		super(name, material);
		setSoundType(SoundType.WOOD);
		setHardness(2.0F);
		setResistance(10.0F);
		setHarvestLevel("axe", 0);
		//setLightLevel(1.0F);
		//setLightOpacity(1);
		//setBlockUnbreakable();
	}
}
