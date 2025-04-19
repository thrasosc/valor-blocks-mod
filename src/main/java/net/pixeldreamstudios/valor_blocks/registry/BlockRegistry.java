package net.pixeldreamstudios.valor_blocks.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.pixeldreamstudios.valor_blocks.ValorBlocks;
import net.pixeldreamstudios.valor_blocks.block.CageBlock;
import net.pixeldreamstudios.valor_blocks.block.SkeletonFloorBlock;
import net.pixeldreamstudios.valor_blocks.block.SkeletonWallBlock;

public class BlockRegistry {
  public static final Block CAGE_BLOCK =
      register(
          new CageBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).noOcclusion()),
          "cage",
          true);
  public static final Block CAGE_SKELETON_BLOCK =
      register(
          new CageBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).noOcclusion()),
          "cage_skeleton",
          true);
  public static final Block SKELETON_FLOOR_BLOCK =
      register(
          new SkeletonFloorBlock(
              BlockBehaviour.Properties.of().sound(SoundType.BONE_BLOCK).noOcclusion()),
          "skeleton_floor",
          true);
  public static final Block SKELETON_WALL_BLOCK =
      register(
          new SkeletonWallBlock(
              BlockBehaviour.Properties.of().sound(SoundType.BONE_BLOCK).noOcclusion()),
          "skeleton_wall",
          true);
  public static final Block EGYPTIAN_STATUE_BLOCK =
      register(
          new CageBlock(BlockBehaviour.Properties.of().sound(SoundType.STONE).noOcclusion()),
          "egyptian_statue",
          true);

  public static Block register(Block block, String name, boolean shouldRegisterItem) {
    // Register the block and its item.
    ResourceLocation blockID = ResourceLocation.fromNamespaceAndPath(ValorBlocks.MOD_ID, name);

    // Sometimes, you may not want to register an item for the block.
    // Eg: if it's a technical block like `minecraft:air` or `minecraft:end_gateway`
    if (shouldRegisterItem) {
      BlockItem blockItem = new BlockItem(block, new Item.Properties());
      Registry.register(BuiltInRegistries.ITEM, blockID, blockItem);
    }

    return Registry.register(BuiltInRegistries.BLOCK, blockID, block);
  }

  public static void init() {
    ValorBlocks.LOGGER.info("Registering items");
  }
}
