package com.pixilaregames.thrivecraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.pixilaregames.thrivecraft.Main;
import com.pixilaregames.thrivecraft.init.ModItems;
import com.pixilaregames.thrivecraft.util.IHasModel;

public class ItemBase extends Item implements IHasModel {

	public ItemBase(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		
		Main.proxy.registerItemRenderer(this, 0,"inventory");
		
	}

}
