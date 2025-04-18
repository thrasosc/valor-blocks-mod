package net.pixeldreamstudios.valor_blocks.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class SkeletonWallBlock extends ValorBlock {
  public static final MapCodec<SkeletonWallBlock> CODEC = simpleCodec(SkeletonWallBlock::new);
  protected static final VoxelShape NORTH_SHAPE = Block.box(2, 0, 10, 14, 14, 15);
  protected static final VoxelShape SOUTH_SHAPE = Block.box(2, 0, 1, 14, 14, 6);
  protected static final VoxelShape WEST_SHAPE = Block.box(10, 0, 2, 15, 14, 14);
  protected static final VoxelShape EAST_SHAPE = Block.box(1, 0, 2, 6, 14, 14);

  public SkeletonWallBlock(Properties properties) {
    super(properties);
  }

  @Override
  protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
    return CODEC;
  }

  @Override
  public @NotNull VoxelShape getShape(
      BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
    return switch (state.getValue(FACING)) {
      case SOUTH -> SOUTH_SHAPE;
      case WEST -> WEST_SHAPE;
      case EAST -> EAST_SHAPE;
      default -> NORTH_SHAPE;
    };
  }
}
