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
  public static final VoxelShape SHAPE = Block.box(2, 0, 10, 14, 14, 15);

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
    return SHAPE;
  }
}
