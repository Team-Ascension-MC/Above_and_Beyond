package net.ascension.aboveandbeyond.datagen;

import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.ascension.aboveandbeyond.block.AABBlocks;
import net.ascension.aboveandbeyond.block.custom.AABWoodTypes;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class AABBlockStateProvider extends BlockStateProvider {
    public AABBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, AboveAndBeyond.MOD_ID, exFileHelper);
    }

    /*Cloud Islands*/
    @Override
    protected void registerStatesAndModels() {
        blockWithItem(AABBlocks.AEROSOIL);
        blockItem(AABBlocks.AEROSOIL_PATH);
        blockWithItem(AABBlocks.COARSE_AEROSOIL);
        blockWithItem(AABBlocks.ZENSTONE);
        stairsBlock(AABBlocks.ZENSTONE_STAIRS.get(), blockTexture(AABBlocks.ZENSTONE.get()));
        slabBlock(AABBlocks.ZENSTONE_SLAB.get(), blockTexture(AABBlocks.ZENSTONE.get()), blockTexture(AABBlocks.ZENSTONE.get()));
        wallBlock(AABBlocks.ZENSTONE_WALL.get(), blockTexture(AABBlocks.ZENSTONE.get()));
        blockWithItem(AABBlocks.POLISHED_ZENSTONE_BRICKS);
        blockWithItem(AABBlocks.CRACKED_POLISHED_ZENSTONE_BRICKS);
        stairsBlock(AABBlocks.POLISHED_ZENSTONE_BRICK_STAIRS.get(), blockTexture(AABBlocks.POLISHED_ZENSTONE_BRICKS.get()));
        slabBlock(AABBlocks.POLISHED_ZENSTONE_BRICK_SLAB.get(), blockTexture(AABBlocks.POLISHED_ZENSTONE_BRICKS.get()), blockTexture(AABBlocks.POLISHED_ZENSTONE_BRICKS.get()));
        wallBlock(AABBlocks.POLISHED_ZENSTONE_BRICK_WALL.get(), blockTexture(AABBlocks.POLISHED_ZENSTONE_BRICKS.get()));
        blockItem(AABBlocks.CHISELED_POLISHED_ZENSTONE_BRICKS);

        logBlock(((RotatedPillarBlock) AABBlocks.WELKIN_LOG.get()));
        axisBlock(((RotatedPillarBlock) AABBlocks.WELKIN_WOOD.get()), blockTexture(AABBlocks.WELKIN_LOG.get()), blockTexture(AABBlocks.WELKIN_LOG.get()));
        logBlock(((RotatedPillarBlock) AABBlocks.STRIPPED_WELKIN_LOG.get()));
        axisBlock(((RotatedPillarBlock) AABBlocks.STRIPPED_WELKIN_WOOD.get()), blockTexture(AABBlocks.STRIPPED_WELKIN_LOG.get()), blockTexture(AABBlocks.STRIPPED_WELKIN_LOG.get()));

        blockItem(AABBlocks.WELKIN_LOG);
        blockItem(AABBlocks.WELKIN_WOOD);
        blockItem(AABBlocks.STRIPPED_WELKIN_LOG);
        blockItem(AABBlocks.STRIPPED_WELKIN_WOOD);
        blockWithItem(AABBlocks.WELKIN_PLANKS);
        stairsBlock(AABBlocks.WELKIN_STAIRS.get(), blockTexture(AABBlocks.WELKIN_PLANKS.get()));
        slabBlock(AABBlocks.WELKIN_SLAB.get(), blockTexture(AABBlocks.WELKIN_PLANKS.get()), blockTexture(AABBlocks.WELKIN_PLANKS.get()));

        buttonBlock(AABBlocks.WELKIN_BUTTON.get(), blockTexture(AABBlocks.WELKIN_PLANKS.get()));
        pressurePlateBlock(AABBlocks.WELKIN_PRESSURE_PLATE.get(), blockTexture(AABBlocks.WELKIN_PLANKS.get()));

        fenceBlock(AABBlocks.WELKIN_FENCE.get(), blockTexture(AABBlocks.WELKIN_PLANKS.get()));
        fenceGateBlock(AABBlocks.WELKIN_FENCE_GATE.get(), blockTexture(AABBlocks.WELKIN_PLANKS.get()));

        doorBlockWithRenderType(AABBlocks.WELKIN_DOOR.get(), modLoc("block/welkin_door_bottom"), modLoc("block/welkin_door_top"), "cutout");
        trapdoorBlockWithRenderType(AABBlocks.WELKIN_TRAPDOOR.get(), modLoc("block/welkin_trapdoor"), true, "cutout");

        blockItem(AABBlocks.WELKIN_STAIRS);
        blockItem(AABBlocks.WELKIN_SLAB);
        blockItem(AABBlocks.WELKIN_PRESSURE_PLATE);
        blockItem(AABBlocks.WELKIN_FENCE_GATE);
        blockItem(AABBlocks.WELKIN_TRAPDOOR, "_bottom");
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("aboveandbeyond:block/" + deferredBlock.getId().getPath()));
    }
    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("aboveandbeyond:block/" + deferredBlock.getId().getPath() + appendix));
    }
}