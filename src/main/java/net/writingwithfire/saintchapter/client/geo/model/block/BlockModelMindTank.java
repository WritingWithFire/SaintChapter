package net.writingwithfire.saintchapter.client.geo.model.block;

import net.minecraft.util.ResourceLocation;
import net.writingwithfire.saintchapter.SaintChapter;
import net.writingwithfire.saintchapter.client.lib.LibGeoResourceLocation;
import net.writingwithfire.saintchapter.common.tile.TileMindTank;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BlockModelMindTank extends AnimatedGeoModel<TileMindTank> {
    @Override
    public ResourceLocation getModelLocation(TileMindTank object) {
        return LibGeoResourceLocation.BlockResourceLocation.MIND_TANK_MODEL;
    }

    @Override
    public ResourceLocation getTextureLocation(TileMindTank object) {
        return LibGeoResourceLocation.BlockResourceLocation.MIND_TANK_TEXTURE;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(TileMindTank animatable) {
        return LibGeoResourceLocation.BlockResourceLocation.MIND_TANK_ANIMATION;
    }
}
