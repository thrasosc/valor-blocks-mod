package net.pixeldreamstudios.valor_blocks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.pixeldreamstudios.valor_blocks.registry.BlockRegistry;

public class ValorBlocksClient implements ClientModInitializer {

  @Override
  public void onInitializeClient() {
    BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.CAGE, RenderType.cutoutMipped());
  }
}
