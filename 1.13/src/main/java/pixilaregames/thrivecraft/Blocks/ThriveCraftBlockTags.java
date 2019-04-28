package pixilaregames.thrivecraft.Blocks;

import java.util.Collection;
import net.minecraft.block.Block;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.tags.TagCollection;
import net.minecraft.util.ResourceLocation;

public class ThriveCraftBlockTags
{
	private static TagCollection<Block> collection = new TagCollection<>((p_203641_0_) -> {
		return false;
	}, (p_203640_0_) -> {
		return null;
	}, "", false, "");
	private static int generation;
	public static final Tag<Block> LEAVES = makeWrapperTag("leaves");
	public static final Tag<Block> LOGS = makeWrapperTag("logs");
	public static final Tag<Block> PETRIFIED_LOGS = makeWrapperTag("petrified_logs");
	
	public static void setCollection(TagCollection<Block> collectionIn)
	{
		collection = collectionIn;
		++generation;
	}
	
	public static TagCollection<Block> getCollection()
	{
		return collection;
	}
	
	private static Tag<Block> makeWrapperTag(String id)
	{
		return new BlockTags.Wrapper(new ResourceLocation(id));
	}
	
	public static class Wrapper extends Tag<Block>
	{
		private int lastKnownGeneration = -1;
		private Tag<Block> cachedTag;
		
		public Wrapper(ResourceLocation resourceloactionIn)
		{
			super(resourceloactionIn);
		}
		
		public boolean contains(Block itemIn)
		{
			if (this.lastKnownGeneration != ThriveCraftBlockTags.generation)
			{
				this.cachedTag = ThriveCraftBlockTags.collection.getOrCreate(this.getId());
				this.lastKnownGeneration = ThriveCraftBlockTags.generation;
			}
			return this.cachedTag.contains(itemIn);
		}
		
		public Collection<Block> getAllElements()
		{
			if(this.lastKnownGeneration != ThriveCraftBlockTags.generation)
			{
				this.cachedTag = ThriveCraftBlockTags.collection.getOrCreate(this.getId());
				this.lastKnownGeneration = ThriveCraftBlockTags.generation;
			}
			return this.cachedTag.getAllElements();
		}
		
		public Collection<Tag.ITagEntry<Block>> getEntries()
		{
			if(this.lastKnownGeneration != ThriveCraftBlockTags.generation)
			{
				this.cachedTag = ThriveCraftBlockTags.collection.getOrCreate(this.getId());
				this.lastKnownGeneration = ThriveCraftBlockTags.generation;
			}
			return this.cachedTag.getEntries();
		}
	}
}
