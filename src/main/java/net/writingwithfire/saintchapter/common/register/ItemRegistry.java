package net.writingwithfire.saintchapter.common.register;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.writingwithfire.saintchapter.common.item.ItemRevelationScroll;
import net.writingwithfire.saintchapter.common.tab.TabLib;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "saintchapter");

    public static final RegistryObject<ItemRevelationScroll> REVELATION_SCROLL = ITEMS.register("revelation_scroll", ItemRevelationScroll::new);

    public static final RegistryObject<BlockItem> IMPREGNATED_STONE_ITEM = ITEMS.register("impregnated_stone_item", () -> new BlockItem(BlockRegistry.IMPREGNATED_STONE.get(), new Item.Properties().tab(TabLib.BASE_TAB)));
}
