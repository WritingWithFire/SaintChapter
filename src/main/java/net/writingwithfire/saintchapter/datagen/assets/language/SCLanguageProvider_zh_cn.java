package net.writingwithfire.saintchapter.datagen.assets.language;

import net.minecraft.data.DataGenerator;
import net.writingwithfire.saintchapter.common.lib.LibAdvancements;
import net.writingwithfire.saintchapter.common.lib.LibName;
import net.writingwithfire.saintchapter.common.lib.LibTranslationText;
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
        add(RegistryItems.BOOK_OF_TRUTH.get(), "真理之书");

        // 方块
        add(RegistryBlocks.MIND_STONE.get(), "心石");
        add(RegistryBlocks.IMPREGNATED_STONE.get(), "浸渍石块");
        add(RegistryBlocks.DEBUG_AND_TEST.get(), "调试方块");
        add(RegistryBlocks.DREAM_FIRE.get(), "梦花火");
        add(RegistryBlocks.WRITING_DESK.get(), "写字桌");

        // 组
        add("itemGroup.saintchapter", "圣章");

        //帕秋莉的书
        String patchouliBookName = "patchouli_books.book_of_truth.";
        add(patchouliBookName + "name", "真理之书");
        add(patchouliBookName + "landing_text", "");
        add(patchouliBookName + "subtitle", "我一直在寻找");

        // 成就
        add(advancementTitle(LibAdvancements.HEAR_ME_HEARTBEAT), "聆听我的心跳");
        add(advancementDescription(LibAdvancements.HEAR_ME_HEARTBEAT), "通过心跳声找到并获取心石");
        add(advancementTitle(LibAdvancements.I_WILL_TELL_YOU), "我们需要知晓");
        add(advancementDescription(LibAdvancements.I_WILL_TELL_YOU), "挖掘心石得到意志结晶，它能告诉你这个世界的真实");

        // 物品注释
        add(LibTranslationText.TOOL_TIP + LibName.ItemName.REVELATION_SCROLL, "你疏浅的学识无以通晓其真谛");
        add(LibTranslationText.TOOL_TIP + LibName.ItemName.MIND_CRYSTAL, "你依稀听得见其中的呼唤");
    }

    private static String advancementTitle(String advancement) {
        return "advancement.saintchapter." + advancement +".title";
    }

    private static String advancementDescription(String advancement) {
        return "advancement.saintchapter." + advancement + ".description";
    }
}
