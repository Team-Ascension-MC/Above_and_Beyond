package net.ascension.aboveandbeyond.block;

import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.ascension.aboveandbeyond.block.custom.AABFlammableRotatedPillarBlock;
import net.ascension.aboveandbeyond.block.custom.ZenGravel;
import net.ascension.aboveandbeyond.item.AABItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class AABBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(AboveAndBeyond.MOD_ID);

    /* Cloud Islands */
    public static final DeferredBlock<Block> PUFFGRASS_BLOCK = registerBlock("puffgrass_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK)));
    public static final DeferredBlock<Block> AEROSOIL = registerBlock("aerosoil",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> COARSE_AEROSOIL = registerBlock("coarse_aerosoil",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COARSE_DIRT)));
    public static final DeferredBlock<Block> ZEN_GRAVEL = registerBlock("zen_gravel",
            () -> new ZenGravel(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAVEL)));

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
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

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