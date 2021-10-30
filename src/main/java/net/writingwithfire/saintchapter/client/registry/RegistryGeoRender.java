package net.writingwithfire.saintchapter.client.registry;

import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.writingwithfire.saintchapter.client.geo.render.block.TileRenderMindTank;
import net.writingwithfire.saintchapter.common.lib.LibTileEntity;

public class RegistryGeoRender {

    public static void registerGeoRender() {
        ClientRegistry.bindTileEntityRenderer(LibTileEntity.MIND_TANK, TileRenderMindTank::new);
    }
}
