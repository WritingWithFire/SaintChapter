package net.writingwithfire.saintchapter.datagen.assets.model;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class SCItemModelProvider extends ItemModelProvider {
    public SCItemModelProvider(DataGenerator gen, String modid, ExistingFileHelper fileHelper) {
        super(gen, modid, fileHelper);
    }

    @Override
    protected void registerModels() {

    }
}
