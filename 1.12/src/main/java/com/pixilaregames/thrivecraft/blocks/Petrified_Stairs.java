package com.pixilaregames.thrivecraft.blocks;

import com.pixilaregames.thrivecraft.Main;
import com.pixilaregames.thrivecraft.util.IHasModel;
import com.pixilaregames.thrivecraft.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;

public class Petrified_Stairs extends BlockStairs
{

	public Petrified_Stairs(String name, IBlockState modelState) {
		super(modelState);
		setUnlocalizedName(name);
		this.useNeighborBrightness = true;
	}

}
