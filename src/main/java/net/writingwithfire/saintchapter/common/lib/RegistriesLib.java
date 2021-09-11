package net.writingwithfire.saintchapter.common.lib;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;
import net.writingwithfire.saintchapter.SaintChapter;
import net.writingwithfire.saintchapter.common.chapter.base.BaseChapter;

public class RegistriesLib {

    private RegistriesLib() {}

    public static final ResourceLocation REGISTRY_NAME_CHAPTERS = SaintChapter.key("chapter");

    public static IForgeRegistry<BaseChapter> REGISTRY_CHAPTER;
}
