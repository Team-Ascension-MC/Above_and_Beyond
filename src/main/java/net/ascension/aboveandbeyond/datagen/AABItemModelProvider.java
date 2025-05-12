package net.ascension.aboveandbeyond.datagen;

import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.ascension.aboveandbeyond.block.AABBlocks;
import net.ascension.aboveandbeyond.item.AABItems;
import net.minecraft.core.BlockPos;
import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class AABItemModelProvider extends ItemModelProvider {
    public AABItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AboveAndBeyond.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(AABItems.MUSIC_DISC_GALE.get());
        basicItem(AABItems.MUSIC_DISC_VIVID.get());

        basicItem(AABBlocks.CLOUD_BLOCK.asItem());
        basicItem(AABItems.CLOUD_BUCKET.get());
        basicItem(AABBlocks.WELKIN_DOOR.asItem());

        basicItem(AABItems.WELKIN_BOAT.get());
        basicItem(AABItems.WELKIN_CHEST_BOAT.get());
    }
}