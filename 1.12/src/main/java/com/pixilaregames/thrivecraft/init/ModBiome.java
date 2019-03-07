package com.pixilaregames.thrivecraft.init;

import com.pixilaregames.thrivecraft.world.biomes.BiomePetrifiedCave;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModBiome
{
	public static final Biome PETRIFIEDCAVE_DIMENSION = new BiomePetrifiedCave();
	
	public static void registerBiomes()
	{
		initBiome(PETRIFIEDCAVE_DIMENSION, "PetrifedCave", BiomeType.COOL, Type.SPOOKY, Type.DENSE, Type.DRY);
	}

	private static void initBiome(Biome biome, String name, BiomeType biomeType, Type... types)
	{
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		System.out.println("Biome Registered");
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addBiome(biomeType, new BiomeEntry(biome, 10));
		BiomeManager.addSpawnBiome(biome);
		System.out.println("Biome Added");
		return;
	}
}
