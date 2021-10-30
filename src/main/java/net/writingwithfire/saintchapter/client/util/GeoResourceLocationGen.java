package net.writingwithfire.saintchapter.client.util;

import net.minecraft.util.ResourceLocation;
import net.writingwithfire.saintchapter.SaintChapter;

public class GeoResourceLocationGen {
    public static ResourceLocation modelLocationGen(String name, String category) {
        return new ResourceLocation(SaintChapter.MODID, "geo/" + category + "/" + name + ".geo.json");
    }

    public static ResourceLocation textureLocationGen(String name, String category) {
        return new ResourceLocation(SaintChapter.MODID, "textures/geo/" + category + "/" + name + ".png");
    }

    public static ResourceLocation animationLocationGen(String name, String category) {
        return new ResourceLocation(SaintChapter.MODID, "animations/" + category + "/" + name + ".animation.json");
    }
}
