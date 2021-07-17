package net.writingwithfire.saintchapter.common.register;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.writingwithfire.saintchapter.common.tile.TileMindStone;

public class TileEntityTypeRegistry {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITYS = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, "saintchapter");

    public static final RegistryObject<TileEntityType<TileMindStone>> MIND_STONE = TILE_ENTITYS.register("mind_stone", () -> TileEntityType.Builder.create(TileMindStone::new, BlockRegistry.MIND_STONE.get()).build(null));
}
