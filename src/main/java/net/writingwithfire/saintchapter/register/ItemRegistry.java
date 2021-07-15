package net.writingwithfire.saintchapter.register;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.writingwithfire.saintchapter.item.ItemRevelationScroll;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "saintchapter");

    public static final RegistryObject<ItemRevelationScroll> REVELATION_SCROLL = ITEMS.register("revelation_scroll", ItemRevelationScroll::new);
}
