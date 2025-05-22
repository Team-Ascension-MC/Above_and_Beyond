//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.ascension.aboveandbeyond.block.custom;

import com.mojang.serialization.MapCodec;
import net.ascension.aboveandbeyond.block.AABBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirtPathBlock;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AerosoilPathBlock extends DirtPathBlock {
    public AerosoilPathBlock(Properties p_153129_) {
        super(p_153129_);
    }
    public static final MapCodec<DirtPathBlock> CODEC = simpleCodec(DirtPathBlock::new);
    protected static VoxelShape SHAPE;

    public MapCodec<DirtPathBlock> codec() {
        return CODEC;
    }

    protected boolean useShapeForLightOcclusion(BlockState p_153159_) {
        return true;
    }

    public BlockState getStateForPlacement(BlockPlaceContext p_153131_) {
        return !this.defaultBlockState().canSurvive(p_153131_.getLevel(), p_153131_.getClickedPos()) ? Block.pushEntitiesUp(this.defaultBlockState(), AABBlocks.AEROSOIL.get().defaultBlockState(), p_153131_.getLevel(), p_153131_.getClickedPos()) : super.getStateForPlacement(p_153131_);
    }

    protected BlockState updateShape(BlockState p_153152_, Direction p_153153_, BlockState p_153154_, LevelAccessor p_153155_, BlockPos p_153156_, BlockPos p_153157_) {
        if (p_153153_ == Direction.UP && !p_153152_.canSurvive(p_153155_, p_153156_)) {
            p_153155_.scheduleTick(p_153156_, this, 1);
        }

        return super.updateShape(p_153152_, p_153153_, p_153154_, p_153155_, p_153156_, p_153157_);
    }

    protected void tick(BlockState p_221070_, ServerLevel p_221071_, BlockPos p_221072_, RandomSource p_221073_) {
        FarmBlock.turnToDirt((Entity)null, p_221070_, p_221071_, p_221072_);
    }

    protected boolean canSurvive(BlockState p_153148_, LevelReader p_153149_, BlockPos p_153150_) {
        BlockState blockstate = p_153149_.getBlockState(p_153150_.above());
        return !blockstate.isSolid() || blockstate.getBlock() instanceof FenceGateBlock;
    }

    protected VoxelShape getShape(BlockState p_153143_, BlockGetter p_153144_, BlockPos p_153145_, CollisionContext p_153146_) {
        return SHAPE;
    }

    protected boolean isPathfindable(BlockState p_153138_, PathComputationType p_153141_) {
        return false;
    }

    static {
        SHAPE = DirtPathBlock.SHAPE;
    }
}
