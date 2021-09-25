package net.writingwithfire.saintchapter.datagen.data.loot.tables;

import net.minecraft.data.loot.ChestLootTables;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.RandomValueRange;
import net.minecraft.util.ResourceLocation;
import net.writingwithfire.saintchapter.SaintChapter;
import net.writingwithfire.saintchapter.common.registry.deferred.gameobjects.RegistryItems;

import java.util.function.BiConsumer;

public class ChestLootTableProvider extends ChestLootTables {

    @Override
    public void accept(BiConsumer<ResourceLocation, LootTable.Builder> registrar) {
        registrar.accept(SaintChapter.key("test_chest"),
                LootTable.builder()
                        .addLootPool(LootPool.builder()
                                .rolls(RandomValueRange.of(3, 5))
                                .bonusRolls(1, 2)
                                .addEntry(ItemLootEntry.builder(RegistryItems.REVELATION_SCROLL.get()).weight(1))));
    }
}
