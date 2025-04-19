package net.pixeldreamstudios.valor_blocks.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class EgyptianStatueBlock extends ValorBlock {

  public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;

  public static final VoxelShape SHAPE_LOWER = Block.box(1.0D, 0.01D, 1.0D, 15.0D, 16.0D, 15.0D);
  public static final VoxelShape SHAPE_UPPER = Block.box(1.0D, 0.01D, 1.0D, 15.0D, 14.0D, 15.0D);

  public static final MapCodec<EgyptianStatueBlock> CODEC = simpleCodec(EgyptianStatueBlock::new);

  public EgyptianStatueBlock(Properties properties) {
    super(properties);
  }

  @Override
  protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
    return CODEC;
  }

  private VoxelShape getShapeForState(BlockState state) {
    return state.getValue(HALF) == DoubleBlockHalf.UPPER ? SHAPE_UPPER : SHAPE_LOWER;
  }

  @Override
  public @NotNull VoxelShape getShape(
      BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
    return getShapeForState(state);
  }

  @Override
  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
    builder.add(HALF, FACING);
  }

  @Nullable
  @Override
  public BlockState getStateForPlacement(BlockPlaceContext context) {
    BlockPos pos = context.getClickedPos();
    Level level = context.getLevel();
    if (pos.getY() < level.getMaxBuildHeight() - 1
        && level.getBlockState(pos.above()).canBeReplaced(context)) {
      return this.defaultBlockState()
          .setValue(FACING, context.getHorizontalDirection())
          .setValue(HALF, DoubleBlockHalf.LOWER);
    } else {
      return null;
    }
  }

  @Override
  public BlockState updateShape(
      BlockState state,
      Direction facing,
      BlockState facingState,
      LevelAccessor level,
      BlockPos currentPos,
      BlockPos facingPos) {
    DoubleBlockHalf half = state.getValue(HALF);
    if (facing.getAxis() == Direction.Axis.Y
        && half == DoubleBlockHalf.LOWER == (facing == Direction.UP)) {
      return facingState.is(this) && facingState.getValue(HALF) != half
          ? state.setValue(FACING, facingState.getValue(FACING))
          : Blocks.AIR.defaultBlockState();
    } else {
      return half == DoubleBlockHalf.LOWER
              && facing == Direction.DOWN
              && !state.canSurvive(level, currentPos)
          ? Blocks.AIR.defaultBlockState()
          : super.updateShape(state, facing, facingState, level, currentPos, facingPos);
    }
  }

  @Override
  public void setPlacedBy(
      Level level, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
    level.setBlock(pos.above(), state.setValue(HALF, DoubleBlockHalf.UPPER), 3);
  }
}
