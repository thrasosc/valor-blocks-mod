package net.pixeldreamstudios.valor_blocks.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CageBlock extends ValorBlock {
  public static final MapCodec<CageBlock> CODEC = simpleCodec(CageBlock::new);
  public static final VoxelShape SHAPE = Block.box(0, -3, 0, 16, 32, 16);

  public CageBlock(Properties properties) {
    super(properties);
  }

  @Override
  protected VoxelShape getShape(
      BlockState blockState,
      BlockGetter blockGetter,
      BlockPos blockPos,
      CollisionContext collisionContext) {
    return SHAPE;
  }

  @Override
  protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
    return CODEC;
  }
}
