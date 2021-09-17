package net.writingwithfire.saintchapter.datagen.assets.model;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class SCBlockModelProvider extends BlockModelProvider {
    public SCBlockModelProvider(DataGenerator gen, String modid, ExistingFileHelper fileHelper) {
        super(gen, modid, fileHelper);
    }

    @Override
    protected void registerModels() {

    }
}
