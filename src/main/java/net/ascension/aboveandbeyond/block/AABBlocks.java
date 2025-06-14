package net.ascension.aboveandbeyond.block;

import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.ascension.aboveandbeyond.block.custom.*;
import net.ascension.aboveandbeyond.block.custom.AerosoilPathBlock;
import net.ascension.aboveandbeyond.item.AABItems;
import net.ascension.aboveandbeyond.worldgen.tree.AABTreeGrowers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class AABBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(AboveAndBeyond.MOD_ID);

    /* SKY ISLANDS */
    //Cloud Islands
    public static final DeferredBlock<GrassBlock> SHORT_PUFFGRASS = BLOCKS.register("short_puffgrass",
            () -> new GrassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final DeferredBlock<GrassBlock> TALL_PUFFGRASS = BLOCKS.register("tall_puffgrass",
            () -> new GrassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final DeferredBlock<FlowerBlock> STARFLOWER = BLOCKS.register("starflower",
            () -> new FlowerBlock(MobEffects.LUCK, 7, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final DeferredBlock<FlowerBlock> SKYACINTH = BLOCKS.register("skyacinth",
            () -> new FlowerBlock(MobEffects.WATER_BREATHING, 15, BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ORCHID).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final DeferredBlock<PuffgrassBlock> PUFFGRASS_BLOCK = registerBlock("puffgrass_block",
            () -> new PuffgrassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK)));
    public static final DeferredBlock<Block> AEROSOIL_PATH = registerBlock("aerosoil_path",
            () -> new AerosoilPathBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT_PATH)));
    public static final DeferredBlock<Block> AEROSOIL = registerBlock("aerosoil",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> COARSE_AEROSOIL = registerBlock("coarse_aerosoil",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COARSE_DIRT)));
    public static final DeferredBlock<Block> ZENSTONE = registerBlock("zenstone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<StairBlock> ZENSTONE_STAIRS = registerBlock("zenstone_stairs",
            () -> new StairBlock(AABBlocks.ZENSTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF_STAIRS)));
    public static final DeferredBlock<SlabBlock> ZENSTONE_SLAB = registerBlock("zenstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF_SLAB)));
    public static final DeferredBlock<WallBlock> ZENSTONE_WALL = registerBlock("zenstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF_WALL)));

    public static final DeferredBlock<Block> POLISHED_ZENSTONE = registerBlock("polished_zenstone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_TUFF)));
    public static final DeferredBlock<StairBlock> POLISHED_ZENSTONE_STAIRS = registerBlock("polished_zenstone_stairs",
            () -> new StairBlock(AABBlocks.POLISHED_ZENSTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_TUFF_STAIRS)));
    public static final DeferredBlock<SlabBlock> POLISHED_ZENSTONE_SLAB = registerBlock("polished_zenstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_TUFF_SLAB)));
    public static final DeferredBlock<WallBlock> POLISHED_ZENSTONE_WALL = registerBlock("polished_zenstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_TUFF_WALL)));

    public static final DeferredBlock<Block> POLISHED_ZENSTONE_BRICKS = registerBlock("polished_zenstone_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF_BRICKS)));
    public static final DeferredBlock<Block> CRACKED_POLISHED_ZENSTONE_BRICKS = registerBlock("cracked_polished_zenstone_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF_BRICKS)));
    public static final DeferredBlock<Block> CHISELED_POLISHED_ZENSTONE_BRICKS = registerBlock("chiseled_polished_zenstone_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CHISELED_TUFF_BRICKS)));
    public static final DeferredBlock<StairBlock> POLISHED_ZENSTONE_BRICK_STAIRS = registerBlock("polished_zenstone_brick_stairs",
            () -> new StairBlock(AABBlocks.POLISHED_ZENSTONE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF_BRICK_STAIRS)));
    public static final DeferredBlock<SlabBlock> POLISHED_ZENSTONE_BRICK_SLAB = registerBlock("polished_zenstone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF_BRICK_SLAB)));
    public static final DeferredBlock<WallBlock> POLISHED_ZENSTONE_BRICK_WALL = registerBlock("polished_zenstone_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF_BRICK_WALL)));

    public static final DeferredBlock<Block> ZEN_GRAVEL = registerBlock("zen_gravel",
            () -> new ZenGravel(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAVEL)));
    public static final DeferredBlock<Block> CLOUD_BLOCK = registerBlock("cloud_block",
            () -> new CloudBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBWEB).sound(SoundType.POWDER_SNOW).instabreak().instrument(NoteBlockInstrument.XYLOPHONE).noOcclusion()));

    public static final DeferredBlock<Block> WELKIN_LOG = registerBlock("welkin_log",
            () -> new AABFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LOG)));
    public static final DeferredBlock<Block> WELKIN_WOOD = registerBlock("welkin_wood",
            () -> new AABFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_WELKIN_LOG = registerBlock("stripped_welkin_log",
            () -> new AABFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_BIRCH_LOG)));
    public static final DeferredBlock<Block> STRIPPED_WELKIN_WOOD = registerBlock("stripped_welkin_wood",
            () -> new AABFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_BIRCH_LOG)));
    public static final DeferredBlock<Block> WELKIN_PLANKS = registerBlock("welkin_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)) {
                @Override
                public boolean isFlammable(@NotNull BlockState state,@NotNull BlockGetter level,@NotNull BlockPos pos,@NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state,@NotNull BlockGetter level,@NotNull BlockPos pos,@NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state,@NotNull BlockGetter level,@NotNull BlockPos pos,@NotNull Direction direction) {
                    return 5;
                }
            });
    public static final DeferredBlock<StairBlock> WELKIN_STAIRS = registerBlock("welkin_stairs",
            () -> new StairBlock(AABBlocks.WELKIN_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_STAIRS)));
    public static final DeferredBlock<SlabBlock> WELKIN_SLAB = registerBlock("welkin_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_SLAB)));

    public static final DeferredBlock<PressurePlateBlock> WELKIN_PRESSURE_PLATE = registerBlock("welkin_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.BIRCH, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PRESSURE_PLATE)));
    public static final DeferredBlock<ButtonBlock> WELKIN_BUTTON = registerBlock("welkin_button",
            () -> new ButtonBlock(BlockSetType.BIRCH, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_BUTTON).noCollission()));

    public static final DeferredBlock<FenceBlock> WELKIN_FENCE = registerBlock("welkin_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_FENCE)));
    public static final DeferredBlock<FenceGateBlock> WELKIN_FENCE_GATE = registerBlock("welkin_fence_gate",
            () -> new FenceGateBlock(WoodType.BIRCH, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_FENCE_GATE)));

    public static final DeferredBlock<DoorBlock> WELKIN_DOOR = registerBlock("welkin_door",
            () -> new DoorBlock(BlockSetType.BIRCH, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_DOOR).noOcclusion()));
    public static final DeferredBlock<TrapDoorBlock> WELKIN_TRAPDOOR = registerBlock("welkin_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.BIRCH, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_TRAPDOOR).noOcclusion()));

    public static final DeferredBlock<Block> WELKIN_SIGN = BLOCKS.register("welkin_sign",
            () -> new AABStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_SIGN), AABWoodTypes.WELKIN));
    public static final DeferredBlock<Block> WELKIN_WALL_SIGN = BLOCKS.register("welkin_wall_sign",
            () -> new AABWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_WALL_SIGN), AABWoodTypes.WELKIN));

    public static final DeferredBlock<Block> WELKIN_HANGING_SIGN = BLOCKS.register("welkin_hanging_sign",
            () -> new AABHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_HANGING_SIGN), AABWoodTypes.WELKIN));
    public static final DeferredBlock<Block> WELKIN_WALL_HANGING_SIGN = BLOCKS.register("welkin_wall_hanging_sign",
            () -> new AABWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_WALL_HANGING_SIGN), AABWoodTypes.WELKIN));

    public static final DeferredBlock<LeavesBlock> WELKIN_LEAVES = registerBlock("welkin_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)));
    public static final DeferredBlock<SaplingBlock> WELKIN_SAPLING = registerBlock("welkin_sapling",
            () -> new SaplingBlock(AABTreeGrowers.WELKIN, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_SAPLING)));

    public static final DeferredBlock<Block> CLOUD_BERRY_BUSH = registerBlock("cloud_berry_bush",
            () -> new CloudBerryBushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH)));

    //Nimbus Islands
    public static final DeferredBlock<PuffgrassBlock> NIMBUS_PUFFGRASS_BLOCK = registerBlock("nimbus_puffgrass_block",
            () -> new PuffgrassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK)));
    public static final DeferredBlock<Block> STORMY_CLOUD_BLOCK = registerBlock("stormy_cloud_block",
            () -> new StormyCloudBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBWEB).sound(SoundType.POWDER_SNOW).instabreak().instrument(NoteBlockInstrument.XYLOPHONE).noOcclusion()));
    public static final DeferredBlock<RotatedPillarBlock> SHOCKROCK = registerBlock("shockrock",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> STATIC_SHOCKROCK = registerBlock("static_shockrock",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> SHOCKROCK_COPPER_ORE = registerBlock("shockrock_copper_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_COPPER_ORE)));
    public static final DeferredBlock<Block> STATIC_DEBRIS = registerBlock("static_debris",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));

    public static final DeferredBlock<Block> COBALT_BLOCK = registerBlock("cobalt_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK).sound(SoundType.NETHERITE_BLOCK)));

    //Ridge Temples
    public static final DeferredBlock<Block> EXPLOSIVE_BARREL = registerBlock("explosive_barrel",
            () -> new ExplosiveBarrel(BlockBehaviour.Properties.ofFullCopy(Blocks.TNT)));

    //Spider Caves
    public static final DeferredBlock<Block> MYGALITH = registerBlock("mygalith",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> POLISHED_MYGALITH = registerBlock("polished_mygalith",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        AABItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}