package net.writingwithfire.saintchapter.datagen.assets.model;

import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.writingwithfire.saintchapter.SaintChapter;
import net.writingwithfire.saintchapter.common.registry.deferred.gameobjects.RegistryItems;
import net.writingwithfire.saintchapter.common.util.NameUtil;

public class SCItemModelProvider extends ItemModelProvider {
    public SCItemModelProvider(DataGenerator gen, String modid, ExistingFileHelper fileHelper) {
        super(gen, modid, fileHelper);
    }

    private static final ResourceLocation GENERATED = new ResourceLocation("item/generated");

    @Override
    protected void registerModels() {
        generatedItem(RegistryItems.REVELATION_SCROLL.get());
        generatedItem(RegistryItems.MIND_CRYSTAL.get());
        generatedItem(RegistryItems.DEBUG_AND_TEST_STICK.get());

//        withExistingParent(NameUtil.getDefaultName(RegistryItems.DEBUG_AND_TEST_STICK.get()), GENERATED).texture("layer0", new ResourceLocation("minecraft", "item/stick"));
    }

    private void generatedItem(Item item) {
        withExistingParent(NameUtil.getDefaultName(item), GENERATED).texture("layer0", itemTexture(item));
    }

    private ResourceLocation itemTexture(Item item) {
        return new ResourceLocation(SaintChapter.MODID, "item/" + NameUtil.getDefaultName(item));
    }
}
