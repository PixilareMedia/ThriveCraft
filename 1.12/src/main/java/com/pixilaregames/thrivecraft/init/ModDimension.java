package com.pixilaregames.thrivecraft.init;

import com.pixilaregames.thrivecraft.world.dimension.petrifiedcave.DimensionPetrifiedCave;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class ModDimension
{
	public static final DimensionType PETRIFIEDCAVE = DimensionType.register("Petrifiedcave", "_petrifiedcave", 2, DimensionPetrifiedCave.class, false);
	
	public static void registerDimensions()
	{
		DimensionManager.registerDimension(2, PETRIFIEDCAVE);
	}
}
