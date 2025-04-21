package net.pixeldreamstudios.valor_blocks.block.state.properties;

import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;

public enum DoubleBlockHalfHorizontal implements StringRepresentable {
  LEADING(Direction.EAST),
  TRAILING(Direction.WEST);

  private final Direction directionToOther;

  DoubleBlockHalfHorizontal(final Direction direction) {
    this.directionToOther = direction;
  }

  public Direction getDirectionToOther() {
    return this.directionToOther;
  }

  public String toString() {
    return this.getSerializedName();
  }

  @Override
  public String getSerializedName() {
    return this == LEADING ? "leading" : "trailing";
  }

  public DoubleBlockHalfHorizontal getOtherHalf() {
    return this == LEADING ? TRAILING : LEADING;
  }
}
