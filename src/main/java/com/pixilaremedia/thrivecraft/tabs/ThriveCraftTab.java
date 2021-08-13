package com.pixilaremedia.thrivecraft.tabs;

import com.pixilaremedia.thrivecraft.init.ItemInit;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ThriveCraftTab extends CreativeModeTab
{
    public ThriveCraftTab(int index, String label)
    {
        super(index, label);
    }

    @Override
    public ItemStack makeIcon()
    {
        return new ItemStack(ItemInit.ONYX_GEM.get());
    }
}
