package com.pixilaregames.thrivecraft.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes
{
	public static void init()
	{
		GameRegistry.addSmelting(ModBlocks.PETRIFIED_LOG, new ItemStack(Items.COAL), 1.5F);
		GameRegistry.addSmelting(ModBlocks.STRIPPED_PETRIFIED_LOG, new ItemStack(Items.COAL), 1.5F);
	}
}
