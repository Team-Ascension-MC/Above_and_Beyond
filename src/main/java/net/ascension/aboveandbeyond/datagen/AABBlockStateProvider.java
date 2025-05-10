package net.ascension.aboveandbeyond.datagen;

import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.ascension.aboveandbeyond.block.AABBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
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
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}