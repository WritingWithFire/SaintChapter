package net.writingwithfire.saintchapter.client.lib;

import net.minecraft.util.ResourceLocation;
import net.writingwithfire.saintchapter.client.util.GeoResourceLocationGen;
import net.writingwithfire.saintchapter.common.lib.LibName;

public class LibGeoResourceLocation {
    private LibGeoResourceLocation() {}

    public static final String BLOCK = "block";
    public static final String ITEM = "item";
    public static final String ENTITY = "entity";
    public static final String ARMOR = "armor";

    public static class BlockResourceLocation {
        public static final ResourceLocation MIND_TANK_MODEL = GeoResourceLocationGen.modelLocationGen(LibName.BlockName.MIND_TANK, BLOCK);
        public static final ResourceLocation MIND_TANK_TEXTURE = GeoResourceLocationGen.textureLocationGen(LibName.BlockName.MIND_TANK, BLOCK);
        public static final ResourceLocation MIND_TANK_ANIMATION = GeoResourceLocationGen.animationLocationGen(LibName.BlockName.MIND_TANK, BLOCK);
    }
}
