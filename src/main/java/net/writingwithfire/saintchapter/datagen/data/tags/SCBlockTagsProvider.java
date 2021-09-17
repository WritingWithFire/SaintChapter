package net.writingwithfire.saintchapter.datagen.data.tags;

import net.minecraft.block.Block;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.TagsProvider;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.writingwithfire.saintchapter.SaintChapter;

public class SCBlockTagsProvider extends BlockTagsProvider {
    public SCBlockTagsProvider(DataGenerator gen, ExistingFileHelper fileHelper) {
        super(gen, SaintChapter.MODID, fileHelper);
    }

    @Override
    protected void registerTags() {

    }

    // 这里模仿AstralSorcery
    private TagsProvider.Builder<Block> tag(ITag.INamedTag<Block> tag) {
        return this.getOrCreateBuilder(tag);
    }
}
