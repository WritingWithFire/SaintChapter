package net.writingwithfire.saintchapter.common.lib;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.writingwithfire.saintchapter.common.registry.deferred.gameobjects.RegistryTileEntities;
import net.writingwithfire.saintchapter.common.tile.TileMindStone;
import net.writingwithfire.saintchapter.common.tile.TileMindTank;
import net.writingwithfire.saintchapter.common.tile.TileWritingDesk;

public class LibTileEntity {

    public static final TileEntityType<TileMindStone> MIND_STONE = RegistryTileEntities.MIND_STONE.get();
    public static final TileEntityType<TileWritingDesk> WRITING_DESK = RegistryTileEntities.WRITING_DESK.get();
    public static final TileEntityType<TileMindTank> MIND_TANK = RegistryTileEntities.MIND_TANK.get();
}
