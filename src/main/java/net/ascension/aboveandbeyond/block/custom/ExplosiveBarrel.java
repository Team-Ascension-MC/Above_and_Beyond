package net.ascension.aboveandbeyond.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class ExplosiveBarrel extends RotatedPillarBlock {
    public ExplosiveBarrel(Properties properties) {
        super(properties);
    }

    protected void onProjectileHit(Level p_306322_, BlockState p_306005_, BlockHitResult p_306105_, Projectile p_305851_) {
        BlockPos blockpos = p_306105_.getBlockPos();
        if (!p_306322_.isClientSide && p_305851_.mayInteract(p_306322_, blockpos) && p_305851_.mayBreak(p_306322_)) {
            p_306322_.explode(null,blockpos.getX() + 0.5, blockpos.getY() + 0.5, blockpos.getZ() + 0.5, 3.5f, false, Level.ExplosionInteraction.TNT);
        }
    }
}
