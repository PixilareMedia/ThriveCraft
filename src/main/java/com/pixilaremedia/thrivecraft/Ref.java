package com.pixilaremedia.thrivecraft;

import com.pixilaremedia.thrivecraft.tabs.ThriveCraftTab;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;

public class Ref
{
    public static Main INSTANCE;
    public static final String MODID = "thrivecraft";
    public static final String CONFIG_FILE = MODID + ".toml";

    public static final ThriveCraftTab TRIVECRAFT_TAB = new ThriveCraftTab(CreativeModeTab.TABS.length, "thrivecraft");

    public static ResourceLocation location(String name)
    {
        return new ResourceLocation(MODID, name);
    }
}
