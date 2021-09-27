package net.writingwithfire.saintchapter.common.lib;

import net.minecraft.block.AbstractBlock;
import net.writingwithfire.saintchapter.common.block.BlockDebugAndTest;
import net.writingwithfire.saintchapter.common.block.BlockDreamFire;
import net.writingwithfire.saintchapter.common.block.BlockImpregnatedStone;
import net.writingwithfire.saintchapter.common.block.BlockMindStone;
import net.writingwithfire.saintchapter.common.item.ItemDebugAndTestStick;
import net.writingwithfire.saintchapter.common.item.ItemMindCrystal;
import net.writingwithfire.saintchapter.common.item.ItemRevelationScroll;
import net.writingwithfire.saintchapter.common.util.NameUtil;

public class NameLib {
    private NameLib() {}

    public static class ItemName {
        public static final String REVELATION_SCROLL = NameUtil.getDefaultName(ItemRevelationScroll.class);
        public static final String MIND_CRYSTAL = NameUtil.getDefaultName(ItemMindCrystal.class);
        public static final String DEBUG_AND_TEST_STICK = NameUtil.getDefaultName(ItemDebugAndTestStick.class);
    }

    public static class BlockName {
        public static final String IMPREGNATED_STONE = NameUtil.getDefaultName(BlockImpregnatedStone.class);
        public static final String MIND_STONE = NameUtil.getDefaultName(BlockMindStone.class);
        public static final String DEBUG_AND_TEST = NameUtil.getDefaultName(BlockDebugAndTest.class);
        public static final String DREAM_FIRE = NameUtil.getDefaultName(BlockDreamFire.class);
    }
}
