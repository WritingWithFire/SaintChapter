package net.writingwithfire.saintchapter.common.registry.internal;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.RegistryBuilder;
import net.writingwithfire.saintchapter.common.chapter.base.BaseChapter;

import static net.writingwithfire.saintchapter.common.lib.LibRegistries.*;


public class RegistryRegistries {

    private RegistryRegistries() {}

    public static void buildRegistries(RegistryEvent.NewRegistry event) {
         REGISTRY_CHAPTER = new RegistryBuilder<BaseChapter>()
                .setName(REGISTRY_NAME_CHAPTERS)
                .setType(BaseChapter.class)
                .disableSaving()
                .disableOverrides()
                .create();
        }
}

