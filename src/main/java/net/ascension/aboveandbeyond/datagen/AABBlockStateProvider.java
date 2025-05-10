package net.ascension.aboveandbeyond.datagen;

import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.ascension.aboveandbeyond.block.AABBlocks;
import net.minecraft.data.PackOutput;
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
        blockWithItem(AABBlocks.COARSE_AEROSOIL);
        blockWithItem(AABBlocks.ZEN_GRAVEL);

        logBlock(((RotatedPillarBlock) AABBlocks.WELKIN_LOG.get()));
        axisBlock(((RotatedPillarBlock) AABBlocks.WELKIN_WOOD.get()), blockTexture(AABBlocks.WELKIN_LOG.get()), blockTexture(AABBlocks.WELKIN_LOG.get()));
        logBlock(((RotatedPillarBlock) AABBlocks.STRIPPED_WELKIN_LOG.get()));
        axisBlock(((RotatedPillarBlock) AABBlocks.STRIPPED_WELKIN_WOOD.get()), blockTexture(AABBlocks.STRIPPED_WELKIN_LOG.get()), blockTexture(AABBlocks.STRIPPED_WELKIN_LOG.get()));

        blockItem(AABBlocks.WELKIN_LOG);
        blockItem(AABBlocks.WELKIN_WOOD);
        blockItem(AABBlocks.STRIPPED_WELKIN_LOG);
        blockItem(AABBlocks.STRIPPED_WELKIN_WOOD);

        blockWithItem(AABBlocks.WELKIN_PLANKS);
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