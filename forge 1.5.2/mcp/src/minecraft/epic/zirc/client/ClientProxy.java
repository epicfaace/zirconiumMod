package epic.zirc.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import epic.zirc.CommonProxy;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
        
        @Override
        public void registerRenderers() {
                //MinecraftForgeClient.preloadTexture(ITEMS_PNG);
                //MinecraftForgeClient.preloadTexture(BLOCK_PNG);
                RenderingRegistry.registerEntityRenderingHandler(epic.zirc.EntityZirc.class, new net.minecraft.client.renderer.entity.RenderSnowball(epic.zirc.Zirc.zirconiumGem));
        }
        
}