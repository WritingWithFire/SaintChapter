package net.writingwithfire.saintchapter.common.lib;

import net.minecraft.block.AbstractBlock;
import net.writingwithfire.saintchapter.common.block.*;
import net.writingwithfire.saintchapter.common.item.ItemBookOfTruth;
import net.writingwithfire.saintchapter.common.item.ItemDebugAndTestStick;
import net.writingwithfire.saintchapter.common.item.ItemMindCrystal;
import net.writingwithfire.saintchapter.common.item.ItemRevelationScroll;
import net.writingwithfire.saintchapter.common.util.NameUtil;

public class LibName {
    private LibName() {}

    public static class ItemName {
        public static final String REVELATION_SCROLL = NameUtil.getDefaultName(ItemRevelationScroll.class);
        public static final String MIND_CRYSTAL = NameUtil.getDefaultName(ItemMindCrystal.class);
        public static final String DEBUG_AND_TEST_STICK = NameUtil.getDefaultName(ItemDebugAndTestStick.class);
        public static final String BOOK_OF_TRUTH = NameUtil.getDefaultName(ItemBookOfTruth.class);
    }

    public static class BlockName {
        public static final String IMPREGNATED_STONE = NameUtil.getDefaultName(BlockImpregnatedStone.class);
        public static final String MIND_STONE = NameUtil.getDefaultName(BlockMindStone.class);
        public static final String DEBUG_AND_TEST = NameUtil.getDefaultName(BlockDebugAndTest.class);
        public static final String DREAM_FIRE = NameUtil.getDefaultName(BlockDreamFire.class);
        public static final String WRITING_DESK = NameUtil.getDefaultName(BlockWritingDesk.class);
    }
}
