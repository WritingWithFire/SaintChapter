package net.writingwithfire.saintchapter.common.registry.deferred;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.writingwithfire.saintchapter.common.tile.TileMindStone;

public class RegistryTileEntities {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIRE = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, "saintchapter");

    public static final RegistryObject<TileEntityType<TileMindStone>> MIND_STONE = TILE_ENTITIRE.register("mind_stone", () -> TileEntityType.Builder.create(TileMindStone::new, RegistryBlocks.MIND_STONE.get()).build(null));
}
