package net.writingwithfire.saintchapter.common.registry.deferred.gameobjects;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.writingwithfire.saintchapter.SaintChapter;
import net.writingwithfire.saintchapter.common.lib.LibBlocks;
import net.writingwithfire.saintchapter.common.tile.TileMindStone;
import net.writingwithfire.saintchapter.common.tile.TileMindTank;
import net.writingwithfire.saintchapter.common.tile.TileWritingDesk;

public class RegistryTileEntities {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, SaintChapter.MODID);

    public static final RegistryObject<TileEntityType<TileMindStone>> MIND_STONE = TILE_ENTITIES.register("mind_stone",
            () -> TileEntityType.Builder.create(TileMindStone::new, LibBlocks.MIND_STONE).build(null));
    public static final RegistryObject<TileEntityType<TileWritingDesk>> WRITING_DESK = TILE_ENTITIES.register("writing_desk",
            () -> TileEntityType.Builder.create(TileWritingDesk::new, LibBlocks.WRITING_DESK).build(null));
    public static final RegistryObject<TileEntityType<TileMindTank>> MIND_TANK = TILE_ENTITIES.register("mind_tank",
            () -> TileEntityType.Builder.create(TileMindTank::new, LibBlocks.MIND_TANK).build(null));
}
