package net.writingwithfire.saintchapter.datagen.data.loot.tables;

import net.minecraft.data.loot.EntityLootTables;
import net.minecraft.entity.EntityType;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.writingwithfire.saintchapter.SaintChapter;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.stream.Collectors;

public class EntityLootTableProvider extends EntityLootTables {
    @Override
    protected void addTables() {

    }

    @Nonnull
    @Override
    protected Iterable<EntityType<?>> getKnownEntities() {
        return ForgeRegistries.ENTITIES.getValues().stream()
                .filter((IForgeRegistryEntry<?> entry) -> {
                    return Objects.requireNonNull(entry.getRegistryName()).getNamespace().equals(SaintChapter.MODID);
                })
                .collect(Collectors.toList());
    }
}
