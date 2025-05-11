package net.ascension.aboveandbeyond.block;

import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.ascension.aboveandbeyond.block.custom.AABFlammableRotatedPillarBlock;
import net.ascension.aboveandbeyond.block.custom.CloudBlock;
import net.ascension.aboveandbeyond.block.custom.ZenGravel;
import net.ascension.aboveandbeyond.item.AABItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
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

    /* Cloud Islands */
    public static final DeferredBlock<FlowerBlock> STARFLOWER = BLOCKS.register("starflower",
            () -> new FlowerBlock(MobEffects.LUCK, 4, BlockBehaviour.Properties.of()
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final DeferredBlock<Block> PUFFGRASS_BLOCK = registerBlock("puffgrass_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK)));
    public static final DeferredBlock<Block> AEROSOIL = registerBlock("aerosoil",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> COARSE_AEROSOIL = registerBlock("coarse_aerosoil",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COARSE_DIRT)));
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
