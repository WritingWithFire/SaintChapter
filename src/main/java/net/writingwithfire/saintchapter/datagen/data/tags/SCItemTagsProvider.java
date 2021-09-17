package net.writingwithfire.saintchapter.datagen.data.tags;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.data.TagsProvider;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.writingwithfire.saintchapter.SaintChapter;

public class SCItemTagsProvider extends ItemTagsProvider {
    public SCItemTagsProvider(DataGenerator generator, BlockTagsProvider blockTagsProvider, ExistingFileHelper fileHelper) {
        super(generator, blockTagsProvider, SaintChapter.MODID, fileHelper);
    }

    @Override
    protected void registerTags() {

    }

    private TagsProvider.Builder<Item> tag(ITag.INamedTag<Item> tag) {
        return this.getOrCreateBuilder(tag);
    }
}
