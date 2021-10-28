package net.writingwithfire.saintchapter.common.registry.deferred.gameobjects;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.writingwithfire.saintchapter.SaintChapter;
import net.writingwithfire.saintchapter.common.tile.TileMindStone;
import net.writingwithfire.saintchapter.common.tile.TileWritingDesk;

public class RegistryTileEntities {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, SaintChapter.MODID);

    public static final RegistryObject<TileEntityType<TileMindStone>> MIND_STONE = TILE_ENTITIES.register("mind_stone",
            () -> TileEntityType.Builder.create(TileMindStone::new, RegistryBlocks.MIND_STONE.get()).build(null));
    public static final RegistryObject<TileEntityType<TileWritingDesk>> WRITING_DESK = TILE_ENTITIES.register("writing_desk",
            () -> TileEntityType.Builder.create(TileWritingDesk::new, RegistryBlocks.WRITING_DESK.get()).build(null));
}
