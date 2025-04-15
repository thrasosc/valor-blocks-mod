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
import net.pixeldreamstudios.valor_blocks.block.ValorBlock;

public class BlockRegistry {
  public static final Block CAGE =
      register(
          new ValorBlock(
              Block.box(0, -3, 0, 16, 32, 16),
              BlockBehaviour.Properties.of().sound(SoundType.METAL)),
          "cage",
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
