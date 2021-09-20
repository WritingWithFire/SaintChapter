package net.writingwithfire.saintchapter.common.registry.deferred.custom;

import net.minecraftforge.registries.DeferredRegister;
import net.writingwithfire.saintchapter.SaintChapter;
import net.writingwithfire.saintchapter.common.chapter.base.BaseChapter;
import net.writingwithfire.saintchapter.common.lib.RegistriesLib;

public class RegistryChapters {
    public static final DeferredRegister<BaseChapter> CHAPTERS = DeferredRegister.create(BaseChapter.class, SaintChapter.MODID);
}
