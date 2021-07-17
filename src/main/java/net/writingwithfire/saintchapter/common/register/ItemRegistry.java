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

    // 注册普通物品
    public static final RegistryObject<Item> REVELATION_SCROLL = ITEMS.register("revelation_scroll", ItemRevelationScroll::new);

    // 注册方块物品
    public static final RegistryObject<Item> IMPREGNATED_STONE = ITEMS.register("impregnated_stone", () -> new BlockItem(BlockRegistry.IMPREGNATED_STONE.get(), new Item.Properties().group(TabLib.BASE_TAB)));
    public static final RegistryObject<Item> MIND_STONE = ITEMS.register("mind_stone", () -> new BlockItem(BlockRegistry.MIND_STONE.get(), new Item.Properties().group(TabLib.BASE_TAB)));
}
