package pixilaregames.thrivecraft.Config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigOptions
{
	public static ForgeConfigSpec.BooleanValue enable;
	public static ForgeConfigSpec.IntValue onyx_ore_chance;
	
	public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client)
	{
		server.comment("Thrive Craft");

		enable = server
				.comment("Should the ??? be enabled")
				.define("configoptions.enable", true);
		onyx_ore_chance = server
				.comment("How Much Should Spawn")
				.defineInRange("configoption.onyx_ore_chance", 100, 1, 1000);
	}
}
