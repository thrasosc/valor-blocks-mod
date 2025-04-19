package net.pixeldreamstudios.valor_blocks.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.pixeldreamstudios.valor_blocks.ValorBlocks;

public class CreativeModeTabRegistry {
  public static final ResourceKey<CreativeModeTab> VALOR_BLOCKS_GROUP_KEY =
      ResourceKey.create(
          BuiltInRegistries.CREATIVE_MODE_TAB.key(),
          ResourceLocation.fromNamespaceAndPath(ValorBlocks.MOD_ID, "creative_mode_tab"));
  public static final CreativeModeTab VALOR_BLOCKS_CREATIVE_MODE_TAB =
      FabricItemGroup.builder()
          .icon(() -> new ItemStack(BlockRegistry.SKELETON_WALL_BLOCK.asItem()))
          .title(Component.translatable("creative_mode_tab." + ValorBlocks.MOD_ID))
          .build();

  public static void init() {
    ValorBlocks.LOGGER.info("Registering creative mode tabs");
    Registry.register(
        BuiltInRegistries.CREATIVE_MODE_TAB,
        VALOR_BLOCKS_GROUP_KEY,
        VALOR_BLOCKS_CREATIVE_MODE_TAB);
    ItemGroupEvents.modifyEntriesEvent(VALOR_BLOCKS_GROUP_KEY)
        .register(
            creativeModeTab -> {
              creativeModeTab.accept(BlockRegistry.CAGE_BLOCK.asItem());
              creativeModeTab.accept(BlockRegistry.CAGE_SKELETON_BLOCK.asItem());
              creativeModeTab.accept(BlockRegistry.SKELETON_FLOOR_BLOCK.asItem());
              creativeModeTab.accept(BlockRegistry.SKELETON_WALL_BLOCK.asItem());
              creativeModeTab.accept(BlockRegistry.EGYPTIAN_STATUE_BLOCK.asItem());
            });
  }
}
