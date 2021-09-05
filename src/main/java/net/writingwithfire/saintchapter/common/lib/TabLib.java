package net.writingwithfire.saintchapter.common.lib;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.writingwithfire.saintchapter.SaintChapter;
import net.writingwithfire.saintchapter.common.registry.deferred.gameobjects.RegistryItems;

public class TabLib {
    public static final ItemGroup ITEM_GROUP_SC = new ItemGroup(SaintChapter.MODID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryItems.REVELATION_SCROLL.get().getItem());
        }
    };
}
