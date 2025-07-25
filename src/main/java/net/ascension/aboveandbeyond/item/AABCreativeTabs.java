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

import static net.ascension.aboveandbeyond.item.AABItems.*;
import static net.ascension.aboveandbeyond.block.AABBlocks.*;

public class AABCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AboveAndBeyond.MOD_ID);

    public static final Supplier<CreativeModeTab> AAB_TAB = CREATIVE_MODE_TAB.register("aab_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(PUFFGRASS_BLOCK.get()))
                    .title(Component.translatable("creativetab.aboveandbeyond.tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        /* SKY ISLANDS */
                        /*Cloud Islands*/
                        output.accept(AABItems.SHORT_PUFFGRASS);
                        output.accept(AABItems.TALL_PUFFGRASS);
                        output.accept(AABItems.STARFLOWER);
                        output.accept(AABItems.SKYACINTH);
                        output.accept(PUFFGRASS_BLOCK);
                        output.accept(AEROSOIL_PATH);
                        output.accept(AEROSOIL);
                        output.accept(COARSE_AEROSOIL);
                        output.accept(ZEN_GRAVEL);
                        output.accept(ZENSTONE);
                        output.accept(ZENSTONE_STAIRS);
                        output.accept(ZENSTONE_SLAB);
                        output.accept(ZENSTONE_WALL);
                        output.accept(POLISHED_ZENSTONE);
                        output.accept(POLISHED_ZENSTONE_STAIRS);
                        output.accept(POLISHED_ZENSTONE_SLAB);
                        output.accept(POLISHED_ZENSTONE_WALL);
                        output.accept(ZENSTONE_BRICKS);
                        output.accept(CRACKED_ZENSTONE_BRICKS);
                        output.accept(ZENSTONE_BRICK_STAIRS);
                        output.accept(ZENSTONE_BRICK_SLAB);
                        output.accept(ZENSTONE_BRICK_WALL);
                        output.accept(CHISELED_ZENSTONE_BRICKS);
                        output.accept(CLOUD_BUCKET);
                        output.accept(CLOUD_BERRIES);
                        output.accept(WELKIN_LOG);
                        output.accept(WELKIN_WOOD);
                        output.accept(STRIPPED_WELKIN_LOG);
                        output.accept(STRIPPED_WELKIN_WOOD);
                        output.accept(WELKIN_PLANKS);
                        output.accept(WELKIN_STAIRS);
                        output.accept(WELKIN_SLAB);
                        output.accept(WELKIN_FENCE);
                        output.accept(WELKIN_FENCE_GATE);
                        output.accept(WELKIN_DOOR);
                        output.accept(WELKIN_TRAPDOOR);
                        output.accept(WELKIN_PRESSURE_PLATE);
                        output.accept(WELKIN_BUTTON);
                        output.accept(WELKIN_LEAVES);
                        output.accept(WELKIN_SAPLING);
                        output.accept(AABItems.WELKIN_SIGN);
                        output.accept(AABItems.WELKIN_HANGING_SIGN);
                        //output.accept(AABItems.WELKIN_BOAT);
                        //output.accept(AABItems.WELKIN_CHEST_BOAT);
                        output.accept(KATANA);
                        output.accept(FLOOF);
                        output.accept(KOI_BUCKET);
                        output.accept(KOI_SPAWN_EGG);
                        output.accept(MUSIC_DISC_GALE);
                        output.accept(MUSIC_DISC_VIVID);

                        //Nimbus Islands
                        output.accept(AABItems.SHORT_STATIC_PUFFGRASS);
                        output.accept(AABItems.TALL_STATIC_PUFFGRASS);
                        output.accept(STATIC_PUFFGRASS_BLOCK);
                        output.accept(AEROMUD);
                        output.accept(SHOCKROCK);
                        output.accept(STATIC_SHOCKROCK);
                        output.accept(SHOCKROCK_COPPER_ORE);
                        output.accept(STATIC_DEBRIS);
                        output.accept(STORMY_CLOUD_BUCKET);
                        output.accept(BUZZ_POWDER);
                        output.accept(LIGHTNING_BOLT);
                        output.accept(COBALT_BLOCK);
                        output.accept(COBALT_SHOVEL);
                        output.accept(COBALT_PICKAXE);
                        output.accept(COBALT_AXE);
                        output.accept(COBALT_HOE);
                        output.accept(COBALT_SWORD);
                        output.accept(COBALT_CROSSBOW);
                        output.accept(COBALT_HELMET);
                        output.accept(COBALT_CHESTPLATE);
                        output.accept(COBALT_LEGGINGS);
                        output.accept(COBALT_BOOTS);
                        output.accept(COBALT_CHUNK);
                        output.accept(COBALT_NUGGET);
                        output.accept(COBALT_INGOT);

                        //Sanctums
                        output.accept(EXPLOSIVE_BARREL);
                        output.accept(MUSIC_DISC_HEIST);

                        //Spider Caves
                        output.accept(MYGALITH);
                        output.accept(POLISHED_MYGALITH);

                        //Meteors
                   //     output.accept(METEORITE_BLOCK);
                    }).build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}