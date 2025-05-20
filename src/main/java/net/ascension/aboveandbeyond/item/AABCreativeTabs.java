package net.ascension.aboveandbeyond.item;

import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.ascension.aboveandbeyond.block.AABBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class AABCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AboveAndBeyond.MOD_ID);

    public static final Supplier<CreativeModeTab> ABOVE_AND_BEYOND_TAB = CREATIVE_MODE_TAB.register("above_and_beyond_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(AABBlocks.PUFFGRASS_BLOCK.get()))
                    .title(Component.translatable("creativetab.aboveandbeyond.items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        /* Cloud Islands */
                        output.accept(AABBlocks.PUFFGRASS_BLOCK);
                        output.accept(AABBlocks.AEROSOIL_PATH);
                        output.accept(AABBlocks.AEROSOIL);
                        output.accept(AABBlocks.COARSE_AEROSOIL);
                        output.accept(AABBlocks.ZEN_GRAVEL);
                        output.accept(AABBlocks.ZENSTONE);
                        output.accept(AABBlocks.ZENSTONE_STAIRS);
                        output.accept(AABBlocks.ZENSTONE_SLAB);
                        output.accept(AABBlocks.ZENSTONE_WALL);
                        output.accept(AABBlocks.POLISHED_ZENSTONE_BRICKS);
                        output.accept(AABBlocks.CRACKED_POLISHED_ZENSTONE_BRICKS);
                        output.accept(AABBlocks.POLISHED_ZENSTONE_BRICK_STAIRS);
                        output.accept(AABBlocks.POLISHED_ZENSTONE_BRICK_SLAB);
                        output.accept(AABBlocks.POLISHED_ZENSTONE_BRICK_WALL);
                        output.accept(AABBlocks.CHISELED_POLISHED_ZENSTONE_BRICKS);
                        output.accept(AABItems.CLOUD_BUCKET);
                        output.accept(AABItems.PUFFGRASS);
                        output.accept(AABItems.STARFLOWER);
                        output.accept(AABItems.SKYACINTH);
                        output.accept(AABItems.CLOUD_BERRY);
                        output.accept(AABBlocks.WELKIN_LOG);
                        output.accept(AABBlocks.WELKIN_WOOD);
                        output.accept(AABBlocks.STRIPPED_WELKIN_LOG);
                        output.accept(AABBlocks.STRIPPED_WELKIN_WOOD);
                        output.accept(AABBlocks.WELKIN_PLANKS);
                        output.accept(AABBlocks.WELKIN_STAIRS);
                        output.accept(AABBlocks.WELKIN_SLAB);
                        output.accept(AABBlocks.WELKIN_FENCE);
                        output.accept(AABBlocks.WELKIN_FENCE_GATE);
                        output.accept(AABBlocks.WELKIN_DOOR);
                        output.accept(AABBlocks.WELKIN_TRAPDOOR);
                        output.accept(AABBlocks.WELKIN_PRESSURE_PLATE);
                        output.accept(AABBlocks.WELKIN_BUTTON);
                        output.accept(AABBlocks.WELKIN_LEAVES);
                        output.accept(AABBlocks.WELKIN_SAPLING);
                        output.accept(AABItems.KATANA);
                        output.accept(AABItems.KOI_BUCKET);
                        output.accept(AABItems.KOI_SPAWN_EGG);
                        output.accept(AABItems.MUSIC_DISC_GALE);
                        output.accept(AABItems.MUSIC_DISC_VIVID);
                        output.accept(AABItems.MUSIC_DISC_HEIST);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
