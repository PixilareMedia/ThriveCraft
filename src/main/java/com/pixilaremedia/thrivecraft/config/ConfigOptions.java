package com.pixilaremedia.thrivecraft.config;

import com.pixilaremedia.thrivecraft.util.helpers.BiomeDictionaryHelper;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ConfigOptions
{
    public static BooleanValue enable;
    //Ore Stuff
    public static BooleanValue onyxOreEnabled;
    public static IntValue onyxPerChunk;
    public static IntValue onyxMaxVeinSize;
    public static IntValue onyxMaxY;
    public static IntValue onyxMinY;
    //Mob Spawn Chances Stuff
    public static IntValue blackWidowSpawnMin;
    public static IntValue blackWidowSpawnMax;
    public static IntValue blackWidowSpawnWeight;
    //Mob Spawnable Biomes Stuff
    public static ConfigValue<List<? extends String>> blackWidowSpawnInclude;
    public static ConfigValue<List<? extends String>> blackWidowSpawnExclude;

    public static void init(ForgeConfigSpec.Builder server)
    {
        server.comment("Thrive Craft");
        //Ore Stuff
        enable = server
                .comment("Should the ??? be enabled")
                .define("Tools.Enable ???", true);
        onyxOreEnabled = server
                .comment("Enable Onyx Ore.")
                .define("Ore Generation.onyxOreEnabled", true);
        onyxPerChunk = server
                .comment("Chance that Onyx generates in a chunk. (0 to Disable)")
                .defineInRange("Ore Generation.onyxPerChunk", 3, 1, 100);
        onyxMaxVeinSize = server
                .comment("Max number of block in an Onyx vein.")
                .defineInRange("Ore Generation.onyxVeinSize", 4, 1, 100);
        onyxMaxY = server
                .comment("Max height at what an Onyx Ore vein can generate.")
                .defineInRange("Ore Generation.onyxMaxY", 30, 1, 100);
        onyxMinY = server
                .comment("Max height at what an Onyx Ore vein can generate.")
                .defineInRange("Ore Generation.onyxMaxY", 5, 1, 100);
        //Mob Spawn Chances Stuff
        blackWidowSpawnMin = server
                .comment("The minimum amount of Black Widows that can spawn in a group.")
                .defineInRange("Mob Spawn Chances.blackWidowSpawnMin", 1, 1, 64);
        blackWidowSpawnMax = server
                .comment("The maximum amount of Black Widows that can spawn in a group.")
                .defineInRange("Mob Spawn Chances.blackWidowSpawnMax", 4, 1, 64);
        blackWidowSpawnWeight = server
                .comment("The chance of spawning a Black Widows. Set to 0 to disable.")
                .defineInRange("Mob Spawn Chances.blackWidowSpawnWeight", 7, 0, 100);
        //Mob Spawnable Biomes Stuff
        blackWidowSpawnInclude = server
                .comment("These biomes are the biome in which the Black Widow can spawn.")
                .defineList("Mob Spawnable Biomes.blackWidowSpawnInclude", Collections.singletonList(BiomeDictionary.Type.SNOWY.toString()), o -> o instanceof  String && (o.equals("") || BiomeDictionary.Type.getAll().contains(BiomeDictionaryHelper.getType(o.toString()))));
        blackWidowSpawnExclude = server
                .comment("These biomes are the biome in which the Black Widow can NOT spawn.")
                .defineList("Mob Spawnable Biomes.blackWidowSpawnExclude", Arrays.asList(BiomeDictionary.Type.END.toString(), BiomeDictionary.Type.NETHER.toString()), o -> o instanceof String && (o.equals("") || BiomeDictionary.Type.getAll().contains(BiomeDictionaryHelper.getType(o.toString()))));
    }
}
