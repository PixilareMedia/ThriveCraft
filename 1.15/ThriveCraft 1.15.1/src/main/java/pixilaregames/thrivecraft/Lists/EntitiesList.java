package pixilaregames.thrivecraft.Lists;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.event.RegistryEvent;
import pixilaregames.thrivecraft.ThriveCraft;
import pixilaregames.thrivecraft.Entities.BlackWidow;

public class EntitiesList
{
	public static EntityType<?> BlackWidow = EntityType.Builder.create(BlackWidow::new, EntityClassification.MONSTER).build(ThriveCraft.modid + ":black_widow").setRegistryName(ThriveCraft.location("black_widow"));
	
	public static void registerEntitySpawnEggs(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll
		(
				ItemList.entity_egg = registerEntitySpawnEgg(BlackWidow, 0x1b1e24, 0x1b3975, "black_widdow_spawn_egg")
		);
	}
	
	public static void registerEntityWorldSpawns()
	{
		registerEntityWorldSpawn(BlackWidow, Biomes.PLAINS);
	}
	
	public static Item registerEntitySpawnEgg(EntityType<?> type, int color1, int color2, String name)
	{
		SpawnEggItem item = new SpawnEggItem(type, color1, color2, new Item.Properties().group(ThriveCraft.thrivecraft));
		item.setRegistryName(ThriveCraft.location(name));
		return item;
	}
	
	public static void registerEntityWorldSpawn(EntityType<?> entity, Biome... biomes)
	{
		for(Biome biome : biomes)
		{
			if(biome !=null)
			{
				biome.getSpawns(entity.getClassification()).add(new SpawnListEntry(entity, 10, 1, 10));
			}
		}
	}
}
