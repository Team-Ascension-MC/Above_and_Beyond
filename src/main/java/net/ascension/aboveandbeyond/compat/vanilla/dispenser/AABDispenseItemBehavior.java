package net.ascension.aboveandbeyond.compat.vanilla.dispenser;

import net.ascension.aboveandbeyond.item.AABItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.world.item.DispensibleContainerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import org.jetbrains.annotations.NotNull;

public class AABDispenseItemBehavior {
    public static void registerDispenseItemBehavior() {

        DispenserBlock.registerBehavior(AABItems.CLOUD_BUCKET.get(), new DefaultDispenseItemBehavior() {
            private final DefaultDispenseItemBehavior defaultDispenseItemBehavior = new DefaultDispenseItemBehavior();

            @Override
            protected @NotNull ItemStack execute(@NotNull BlockSource blockSource, @NotNull ItemStack item) {
                DispensibleContainerItem dispensibleContainerItem = (DispensibleContainerItem) item.getItem();
                BlockPos blockPos = blockSource.pos().relative(blockSource.state().getValue(DispenserBlock.FACING));
                Level level = blockSource.level();
                if (dispensibleContainerItem.emptyContents(null, level, blockPos, null)) {
                    dispensibleContainerItem.checkExtraContent(null, level, item, blockPos);
                    return new ItemStack(Items.BUCKET);
                } else return this.defaultDispenseItemBehavior.dispense(blockSource, item);
            }
        });
    }
}
