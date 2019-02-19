package com.pixilaregames.thrivecraft.commands;

import java.util.List;

import com.google.common.collect.Lists;
import com.pixilaregames.thrivecraft.commands.util.Teleport;
import com.pixilaregames.thrivecraft.util.Reference;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class CommandDimensionTleport extends CommandBase
{
	private final List<String> aliases = Lists.newArrayList(Reference.MOD_ID, "tp", "tpdimn", "tpdimension", "telportdimension", "teleport");
	
	@Override
	public String getName()
	{
		return "tpdimension";
	}

	@Override
	public String getUsage(ICommandSender sender)
	{
		return "tpdimansion <id>";
	}
	
	@Override
	public List<String> getAliases()
	{
		return aliases;
	}
	
	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender)
	{
		return true;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
	{
		if(args.length < 1) return;
		
		String s = args[0];
		int dimensionID = 0;
		
		try
		{
			dimensionID = Integer.parseInt(s);
		}catch(NumberFormatException e)
		{
			sender.sendMessage(new TextComponentString(TextFormatting.RED + "Dimension ID Invalid"));
		}
		
		if(sender instanceof EntityPlayer)
		{
			if(dimensionID == 1)
			{
				Teleport.teleportToDimension((EntityPlayer)sender, dimensionID, 0, 55, 0);
			}
			else
			{
				Teleport.teleportToDimension((EntityPlayer)sender, dimensionID, sender.getPosition().getX(), sender.getPosition().getY(), sender.getPosition().getZ());
			}
		}
	}

}
