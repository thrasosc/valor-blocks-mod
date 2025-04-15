package net.pixeldreamstudios.valor_blocks.block;

import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import org.jetbrains.annotations.Nullable;

public abstract class ValorBlock extends HorizontalDirectionalBlock {

  public ValorBlock(Properties properties) {
    super(properties);
  }

  @Nullable
  @Override
  public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
    return defaultBlockState()
        .setValue(FACING, blockPlaceContext.getHorizontalDirection().getOpposite());
  }

  @Override
  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
    builder.add(FACING);
  }
}
