package com.pixilaregames.thrivecraft.init;

import java.util.ArrayList;
import java.util.List;

import com.pixilaregames.thrivecraft.blocks.BlockBase;
import com.pixilaregames.thrivecraft.blocks.Petrified_Bark;
import com.pixilaregames.thrivecraft.blocks.BlockDoorBase;
import com.pixilaregames.thrivecraft.blocks.Petrified_Door;
import com.pixilaregames.thrivecraft.blocks.Petrified_Log;
import com.pixilaregames.thrivecraft.blocks.Petrified_Planks;
import com.pixilaregames.thrivecraft.blocks.Petrified_Sapling;
import com.pixilaregames.thrivecraft.blocks.Stripped_Petrified_Bark;
import com.pixilaregames.thrivecraft.blocks.Stripped_Petrified_Log;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block PETRIFIED_PLANKS = new Petrified_Planks("petrified_planks", Material.WOOD);
	public static final Block PETRIFIED_BARK = new Petrified_Bark("petrified_bark", Material.WOOD);
	public static final Block PETRIFIED_LOG = new Petrified_Log("petrified_log", Material.WOOD);
	public static final Block STRIPPED_PETRIFIED_LOG = new Stripped_Petrified_Log("stripped_petrified_log", Material.WOOD);
	public static final Block STRIPPED_PETRIFIED_BARK = new Stripped_Petrified_Bark("stripped_petrified_bark", Material.WOOD);
	public static final Block PETRIFIED_SAPLING = new Petrified_Sapling("petrified_sapling", Material.WOOD);
	public static final Block PETRIFIED_DOOR = new Petrified_Door("petrified_door", Material.WOOD);
}
