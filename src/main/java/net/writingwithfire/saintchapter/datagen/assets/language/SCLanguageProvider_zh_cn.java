package net.writingwithfire.saintchapter.datagen.assets.language;

import net.minecraft.data.DataGenerator;
import net.writingwithfire.saintchapter.common.registry.deferred.gameobjects.RegistryBlocks;
import net.writingwithfire.saintchapter.common.registry.deferred.gameobjects.RegistryItems;

public class SCLanguageProvider_zh_cn extends net.minecraftforge.common.data.LanguageProvider {
    public SCLanguageProvider_zh_cn(DataGenerator gen, String modid, String locale) {
        super(gen, modid, locale);
    }

    // 我有必要来说明一下这个翻译的问题，文件输出的中文永远是乱码，gradle里面设置过，不过不太管用，但是实际测试不影响使用。
    @Override
    protected void addTranslations() {
        // 物品
        add(RegistryItems.REVELATION_SCROLL.get(), "启示卷轴");
        add(RegistryItems.MIND_CRYSTAL.get(), "远古意志结晶");
        add(RegistryItems.DEBUG_AND_TEST_STICK.get(), "调试棒");

        // 方块
        add(RegistryBlocks.MIND_STONE.get(), "心石");
        add(RegistryBlocks.IMPREGNATED_STONE.get(), "浸渍石块");
        add(RegistryBlocks.DEBUG_AND_TEST.get(), "调试方块");
        add(RegistryBlocks.DREAM_FIRE.get(), "梦花火");

        // 组
        add("itemGroup.saintchapter", "圣章");

        //帕秋莉的书
        String patchouliBookName = "patchouli_books.book_of_truth.";
        add(patchouliBookName + "name", "真理之书");
        add(patchouliBookName + "landing_text", "");
        add(patchouliBookName + "subtitle", "我一直在寻找");

        // 成就
        String advancementPrefix = "advancement.saintchapter.";
        add(advancementPrefix + "hear_me_heartbeat.title", "聆听我的心跳");
        add(advancementPrefix + "hear_me_heartbeat.description", "通过心跳声找到并获取心石");
    }
}
