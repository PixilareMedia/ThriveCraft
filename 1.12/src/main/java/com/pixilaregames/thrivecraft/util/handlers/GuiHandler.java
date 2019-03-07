package com.pixilaregames.thrivecraft.util.handlers;

import com.pixilaregames.thrivecraft.blocks.container.ContainerPetrifiedChest;
import com.pixilaregames.thrivecraft.blocks.gui.GuiPetrifiedChest;
import com.pixilaregames.thrivecraft.blocks.tileentity.TileEntityPetrifiedChest;
import com.pixilaregames.thrivecraft.util.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if(ID == Reference.GUI_PETRIFIED_CHEST) return new ContainerPetrifiedChest(player.inventory, (TileEntityPetrifiedChest)world.getTileEntity(new BlockPos(z,y,z)), player);
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if(ID == Reference.GUI_PETRIFIED_CHEST) return new GuiPetrifiedChest(player.inventory, (TileEntityPetrifiedChest)world.getTileEntity(new BlockPos(x,y,z)), player);
		return null;
	}
	
	public static void registerGUIs()
	{
		
	}
}
