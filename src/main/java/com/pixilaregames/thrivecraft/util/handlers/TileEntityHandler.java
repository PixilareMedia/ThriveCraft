package com.pixilaregames.thrivecraft.util.handlers;

import com.pixilaregames.thrivecraft.blocks.tileentity.TileEntityPetrifiedChest;
import com.pixilaregames.thrivecraft.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler
{
	public static void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityPetrifiedChest.class, new ResourceLocation(Reference.MOD_ID + ":petrified_chest"));
	}
}
