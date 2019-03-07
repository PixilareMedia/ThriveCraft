package com.pixilaregames.thrivecraft.world.dimension.petrifiedcave;

import com.pixilaregames.thrivecraft.init.ModBiome;
import com.pixilaregames.thrivecraft.init.ModDimension;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;

public class DimensionPetrifiedCave extends WorldProvider
{
	public DimensionPetrifiedCave()
	{
		this.biomeProvider = new BiomeProviderSingle(ModBiome.PETRIFIEDCAVE_DIMENSION);
	}
	
	@Override
	public DimensionType getDimensionType()
	{
		return ModDimension.PETRIFIEDCAVE;
	}
	
	@Override
	public IChunkGenerator createChunkGenerator()
	{
		return new createChunkGeneratorPetrifiedCave(world, true, world.getSeed());
	}
	
	@Override
	public boolean canRespawnHere()
	{
		return false;
	}
	
	@Override
	public boolean isSurfaceWorld()
	{
		return false;
	}
}
