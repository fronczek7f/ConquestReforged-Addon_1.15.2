package net.sevil.cra.block;

import it.unimi.dsi.fastutil.objects.Object2ByteLinkedOpenHashMap;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.Half;
import net.minecraft.state.properties.StairsShape;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;
import java.util.function.Supplier;

public class RoofTileBlock extends Block {
    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    public static final EnumProperty<Half> HALF = BlockStateProperties.HALF;
    public static final EnumProperty<StairsShape> SHAPE = BlockStateProperties.STAIRS_SHAPE;
    private final Supplier<BlockState> stateSupplier;
    private final Block modelBlock;
    private final BlockState modelState;

    public RoofTileBlock(Supplier<BlockState> state, Block.Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(HALF, Half.BOTTOM).with(SHAPE, StairsShape.STRAIGHT));
        this.modelBlock = Blocks.AIR;
        this.modelState = Blocks.AIR.getDefaultState();
        this.stateSupplier = state;
    }

    @Override
    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (state.getBlock() != state.getBlock()) {
            this.modelState.neighborChanged(worldIn, pos, Blocks.AIR, pos, false);
            this.modelBlock.onBlockAdded(this.modelState, worldIn, pos, oldState, false);
        }
    }

    @Override
    public void func_225534_a_(BlockState p_225534_1_, ServerWorld p_225534_2_, BlockPos p_225534_3_, Random p_225534_4_) {
        this.modelBlock.func_225534_a_(p_225534_1_, p_225534_2_, p_225534_3_, p_225534_4_);
    }

    @Override
    public ActionResultType func_225533_a_(BlockState p_225533_1_, World p_225533_2_, BlockPos p_225533_3_, PlayerEntity p_225533_4_, Hand p_225533_5_, BlockRayTraceResult p_225533_6_) {
        return this.modelState.func_227031_a_(p_225533_2_, p_225533_4_, p_225533_5_, p_225533_6_);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        Direction direction = context.getFace();
        BlockPos blockpos = context.getPos();
        IFluidState ifluidstate = context.getWorld().getFluidState(blockpos);
        BlockState blockstate = this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing()).with(HALF, direction != Direction.DOWN && (direction == Direction.UP || !(context.getHitVec().y - (double)blockpos.getY() > 0.5D)) ? Half.BOTTOM : Half.TOP);
        return blockstate.with(SHAPE, getShapeProperty(blockstate, context.getWorld(), blockpos));
    }

    private static StairsShape getShapeProperty(BlockState state, IBlockReader worldIn, BlockPos pos) {
        Direction direction = state.get(FACING);
        BlockState blockstate = worldIn.getBlockState(pos.offset(direction));
        if (isBlockRoofTiles(blockstate) && state.get(HALF) == blockstate.get(HALF)) {
            Direction direction1 = blockstate.get(FACING);
            if (direction1.getAxis() != state.get(FACING).getAxis() && isDifferentRoofTiles(state, worldIn, pos, direction1.getOpposite())) {
                if (direction1 == direction.rotateYCCW()) {
                    return StairsShape.OUTER_LEFT;
                }

                return StairsShape.OUTER_RIGHT;
            }
        }

        BlockState blockstate1 = worldIn.getBlockState(pos.offset(direction.getOpposite()));
        if (isBlockRoofTiles(blockstate1) && state.get(HALF) == blockstate1.get(HALF)) {
            Direction direction2 = blockstate1.get(FACING);
            if (direction2.getAxis() != state.get(FACING).getAxis() && isDifferentRoofTiles(state, worldIn, pos, direction2)) {
                if (direction2 == direction.rotateYCCW()) {
                    return StairsShape.INNER_LEFT;
                }

                return StairsShape.INNER_RIGHT;
            }
        }

        return StairsShape.STRAIGHT;
    }

    private static boolean isDifferentRoofTiles(BlockState state, IBlockReader worldIn, BlockPos pos, Direction face) {
        BlockState blockstate = worldIn.getBlockState(pos.offset(face));
        return !isBlockRoofTiles(blockstate) || blockstate.get(FACING) != state.get(FACING) || blockstate.get(HALF) != state.get(HALF);
    }

    public static boolean isBlockRoofTiles(BlockState state) {
        return state.getBlock() instanceof RoofTileBlock;
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        Direction direction = state.get(FACING);
        StairsShape stairsshape = state.get(SHAPE);
        switch(mirrorIn) {
            case LEFT_RIGHT:
                if (direction.getAxis() == Direction.Axis.Z) {
                    switch(stairsshape) {
                        case INNER_LEFT:
                            return state.rotate(Rotation.CLOCKWISE_180).with(SHAPE, StairsShape.INNER_RIGHT);
                        case INNER_RIGHT:
                            return state.rotate(Rotation.CLOCKWISE_180).with(SHAPE, StairsShape.INNER_LEFT);
                        case OUTER_LEFT:
                            return state.rotate(Rotation.CLOCKWISE_180).with(SHAPE, StairsShape.OUTER_RIGHT);
                        case OUTER_RIGHT:
                            return state.rotate(Rotation.CLOCKWISE_180).with(SHAPE, StairsShape.OUTER_LEFT);
                        default:
                            return state.rotate(Rotation.CLOCKWISE_180);
                    }
                }
                break;
            case FRONT_BACK:
                if (direction.getAxis() == Direction.Axis.X) {
                    switch(stairsshape) {
                        case INNER_LEFT:
                            return state.rotate(Rotation.CLOCKWISE_180).with(SHAPE, StairsShape.INNER_LEFT);
                        case INNER_RIGHT:
                            return state.rotate(Rotation.CLOCKWISE_180).with(SHAPE, StairsShape.INNER_RIGHT);
                        case OUTER_LEFT:
                            return state.rotate(Rotation.CLOCKWISE_180).with(SHAPE, StairsShape.OUTER_RIGHT);
                        case OUTER_RIGHT:
                            return state.rotate(Rotation.CLOCKWISE_180).with(SHAPE, StairsShape.OUTER_LEFT);
                        case STRAIGHT:
                            return state.rotate(Rotation.CLOCKWISE_180);
                    }
                }
        }

        return super.mirror(state, mirrorIn);
    }

    @OnlyIn(Dist.CLIENT)
    public static boolean shouldSideBeRendered(BlockState adjacentState, IBlockReader blockState, BlockPos blockAccess, Direction pos) {
        return false;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING, HALF, SHAPE);
    }

    private Block getModelBlock() {
        return getModelState().getBlock();
    }

    private BlockState getModelState() {
        return stateSupplier.get();
    }
}
