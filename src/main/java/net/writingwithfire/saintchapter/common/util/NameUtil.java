package net.writingwithfire.saintchapter.common.util;

import com.google.common.base.CaseFormat;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.writingwithfire.saintchapter.SaintChapter;
import net.writingwithfire.saintchapter.common.item.ItemRevelationScroll;

import javax.annotation.Nullable;

public class NameUtil {
    // 获取名字
    public static String getDefaultName(Object object) {
        if (object instanceof Item) return getDefaultName(object, "Item");
        if (object instanceof Block) return getDefaultName(object, "Block");
        return getDefaultName(object, null);
    }

    public static String getDefaultName(Class<?> clazz) {
        if (Item.class.isAssignableFrom(clazz)) return getDefaultName(clazz, "Item");
        if (Block.class.isAssignableFrom(clazz)) return getDefaultName(clazz, "Block");
        return getDefaultName(clazz, null);
    }

    public static String getDefaultName(Object object, @Nullable String cutPrefix) {
        return getDefaultName(object, cutPrefix, null);
    }

    public static String getDefaultName(Class<?> clazz, @Nullable String cutPrefix) {
        return getDefaultName(clazz, cutPrefix, null);
    }

    public static String getDefaultName(Object object, @Nullable String cutPrefix, @Nullable String cutSuffix) {
        return getDefaultName(object.getClass(), cutPrefix, cutSuffix);
    }

    public static String getDefaultName(Class<?> clazz, @Nullable String cutPrefix, @Nullable String cutSuffix) {
        String name = clazz.getSimpleName();
        if (clazz.getEnclosingClass() != null) {
            name = clazz.getEnclosingClass().getSimpleName() + name;
        }
        if (cutPrefix != null && name.startsWith(cutPrefix)) {
            name = name.substring(cutPrefix.length());
        }
        if (cutSuffix != null && name.endsWith(cutSuffix)) {
            name = name.substring(0, name.length() - cutSuffix.length());
        }
        name = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name);
        return name;
    }
}
