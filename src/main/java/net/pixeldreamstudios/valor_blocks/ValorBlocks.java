package net.pixeldreamstudios.valor_blocks;

import net.fabricmc.api.ModInitializer;
import net.pixeldreamstudios.valor_blocks.registry.BlockRegistry;
import net.pixeldreamstudios.valor_blocks.registry.CreativeModeTabRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ValorBlocks implements ModInitializer {
  public static final String MOD_ID = "valor_blocks";
  public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

  @Override
  public void onInitialize() {
    BlockRegistry.init();
    CreativeModeTabRegistry.init();
  }
}
