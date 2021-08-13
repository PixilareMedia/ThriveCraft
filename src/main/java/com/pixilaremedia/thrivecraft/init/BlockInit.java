package com.pixilaremedia.thrivecraft.init;

import com.pixilaremedia.thrivecraft.Ref;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.grower.OakTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Ref.MODID);

    //Onyx Blocks
    public static RegistryObject<Block> ONYX_BLOCK = BLOCKS.register("onyx_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.TERRACOTTA_PURPLE).requiresCorrectToolForDrops().strength(1.0f, 1.0f).sound(SoundType.METAL).harvestLevel(4)));
    public static RegistryObject<Block> ONYX_ORE = BLOCKS.register("onyx_ore", () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.0f, 1.0f).sound(SoundType.STONE).harvestLevel(4), UniformInt.of(3, 7)));

    //Petrified Blocks
    public static RegistryObject<Block> STRIPPED_PETRIFIED_LOG = BLOCKS.register("stripped_petrified_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(1.0f, 1.0f).sound(SoundType.WOOD)));
    public static RegistryObject<Block> STRIPPED_PETRIFIED_BARK = BLOCKS.register("stripped_petrified_bark", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(1.0f, 1.0f).sound(SoundType.WOOD)));
    public static RegistryObject<Block> PETRIFIED_LOG = BLOCKS.register("petrified_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(1.0f, 1.0f).sound(SoundType.WOOD)));
    public static RegistryObject<Block> PETRIFIED_BARK = BLOCKS.register("petrified_bark", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(1.0f, 1.0f).sound(SoundType.WOOD)));
    public static RegistryObject<Block> PETRIFIED_PLANKS = BLOCKS.register("petrified_planks", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(1.0f, 1.0f).sound(SoundType.WOOD)));
    public static RegistryObject<Block> PETRIFIED_DOOR = BLOCKS.register("petrified_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(1.0f, 1.0f).sound(SoundType.WOOD).noOcclusion()));
    public static RegistryObject<Block> PETRIFIED_SAPLING = BLOCKS.register("petrified_sapling", () -> new SaplingBlock(new OakTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noOcclusion().noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
    public static RegistryObject<Block> PETRIFIED_SLAB = BLOCKS.register("petrified_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(1.0f, 1.0f).sound(SoundType.WOOD)));
    public static RegistryObject<Block> PETRIFIED_STAIRS = BLOCKS.register("petrified_stairs", () -> new StairBlock(BlockInit.PETRIFIED_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.WOOD).strength(1.0f, 1.0f).sound(SoundType.WOOD)));
    public static RegistryObject<Block> PETRIFIED_LEAVES = BLOCKS.register("petrified_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(1.0f, 1.0f).sound(SoundType.GRASS).noOcclusion()));
    public static RegistryObject<Block> PETRIFIED_FENCE = BLOCKS.register("petrified_fence", () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(1.0f, 1.0f).sound(SoundType.WOOD)));
    public static RegistryObject<Block> PETRIFIED_FENCE_GATE = BLOCKS.register("petrified_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(1.0f, 1.0f).sound(SoundType.WOOD)));
    public static RegistryObject<Block> PETRIFIED_TRAPDOOR = BLOCKS.register("petrified_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(1.0f, 1.0f).sound(SoundType.WOOD).noOcclusion()));
    public static RegistryObject<Block> PETRIFIED_PRESSURE_PLATE = BLOCKS.register("petrified_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD).strength(1.0f, 1.0f).sound(SoundType.WOOD).noOcclusion()));
    public static RegistryObject<Block> PETRIFIED_BUTTON = BLOCKS.register("petrified_button", () -> new WoodButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION).strength(1.0f, 1.0f).sound(SoundType.WOOD).noCollission()));
    public static RegistryObject<Block> PETRIFIED_CHEST = BLOCKS.register("petrified_chest", () -> new ChestBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(1.0f, 1.0f).sound(SoundType.WOOD), () -> { return BlockEntityType.CHEST; }));
    public static RegistryObject<Block> PETRIFIED_SIGN;
}
