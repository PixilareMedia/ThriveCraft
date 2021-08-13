package com.pixilaremedia.thrivecraft.data;

import net.minecraft.core.Registry;
import net.minecraft.tags.StaticTagHelper;
import net.minecraft.tags.StaticTags;
import net.minecraft.tags.Tag;
import net.minecraft.tags.TagCollection;
import net.minecraft.world.level.block.Block;

public class TCBlockTags {
    protected static final StaticTagHelper<Block> HELPER = StaticTags.create(Registry.BLOCK_REGISTRY, "tags/blocks");
    public static final Tag.Named<Block> NEEDS_NETHERITE_TOOL = bind("needs_netherite_tool");

    private TCBlockTags() {}

    public static Tag.Named<Block> bind(String p_13117_) {
        return HELPER.bind(p_13117_);
    }

    public static net.minecraftforge.common.Tags.IOptionalNamedTag<Block> createOptional(net.minecraft.resources.ResourceLocation name) {
        return createOptional(name, null);
    }

    public static net.minecraftforge.common.Tags.IOptionalNamedTag<Block> createOptional(net.minecraft.resources.ResourceLocation name, @javax.annotation.Nullable java.util.Set<java.util.function.Supplier<Block>> defaults) {
        return HELPER.createOptional(name, defaults);
    }

    public static TagCollection<Block> getAllTags() {
        return HELPER.getAllTags();
    }
}
