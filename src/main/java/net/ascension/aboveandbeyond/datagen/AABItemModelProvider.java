package net.ascension.aboveandbeyond.datagen;

import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.ascension.aboveandbeyond.block.AABBlocks;
import net.ascension.aboveandbeyond.item.AABItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class AABItemModelProvider extends ItemModelProvider {
    public AABItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AboveAndBeyond.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(AABItems.MUSIC_DISC_GALE.get());
        basicItem(AABItems.MUSIC_DISC_VIVID.get());

        basicItem(AABBlocks.WELKIN_DOOR.asItem());
        }
    }