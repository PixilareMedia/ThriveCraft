package pixilaregames.thrivecraft.Config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;

public class ConfigOptions
{
	public static BooleanValue enable;
	public static IntValue onyx_ore_chance;
	public static IntValue onyxPerChunk;
	public static IntValue onyxMaxVeinSize;
	
	public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client)
	{
		server.comment("Thrive Craft");

		enable = server
				.comment("Should the ??? be enabled")
				.define("Tools.Enable ???", true);
		onyxPerChunk = server
				.comment("Chance that Onyx generates in a chunk. (0 to Disable)")
				.defineInRange("Ore Generation.onyxPerChunk", 3, 0, Integer.MAX_VALUE);
		onyxMaxVeinSize = server
				.comment("Max number of block in an Onyx vein.")
				.defineInRange("Ore Generation.onyxVeinSize", 4, 1, Integer.MAX_VALUE);
	}
}
