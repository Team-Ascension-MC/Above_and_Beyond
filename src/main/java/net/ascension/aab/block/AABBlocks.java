package net.ascension.aab.block;

import net.ascension.aab.AboveAndBeyond;
import net.ascension.aab.item.AABItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class AABBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(AboveAndBeyond.MOD_ID);

    //Cloud Islands
    public static final DeferredBlock<Block> PUFFGRASS_BLOCK = registerBlock("puffgrass_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK)));

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
