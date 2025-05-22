package net.ascension.aboveandbeyond.block.custom;

import net.ascension.aboveandbeyond.item.AABItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class CloudBerryBush extends SweetBerryBushBlock {
    public CloudBerryBush(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state) {
        return new ItemStack((ItemLike) AABItems.CLOUD_BERRY);
    }
}
