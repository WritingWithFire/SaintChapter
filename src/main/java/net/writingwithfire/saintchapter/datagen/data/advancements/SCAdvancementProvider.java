package net.writingwithfire.saintchapter.datagen.data.advancements;

import com.google.common.collect.Sets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.data.AdvancementProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.registries.ForgeRegistries;
import net.writingwithfire.saintchapter.SaintChapter;
import net.writingwithfire.saintchapter.common.lib.LibAdvancements;
import net.writingwithfire.saintchapter.common.lib.LibRecipes;
import net.writingwithfire.saintchapter.common.registry.deferred.gameobjects.RegistryItems;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;

public class SCAdvancementProvider extends net.minecraft.data.AdvancementProvider {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().create();
    private final DataGenerator generator;

    public SCAdvancementProvider(DataGenerator generator) {
        super(generator);
        this.generator = generator;
    }

    @Override
    public void act(DirectoryCache cache) {
        Path path = this.generator.getOutputFolder();
        Set<ResourceLocation> set = Sets.newHashSet();
        Consumer<Advancement> registrar = (advancement) -> {
            if (!set.add(advancement.getId())) {
                throw new IllegalStateException("Duplicate advancement " + advancement.getId());
            } else {
                Path outPath = getPath(path, advancement);
                try {
                    IDataProvider.save(GSON, cache, advancement.copy().serialize(), outPath);
                } catch (IOException ioexception) {
                    LOGGER.error("Couldn't save advancement {}", outPath, ioexception);
                }
            }
        };

        this.registerAdvancements(registrar);
    }

    private void registerAdvancements(Consumer<Advancement> registrar) {
        Advancement heart_me_heartbeat = Advancement.Builder.builder()
                .withDisplay(RegistryItems.RegistryBlockItems.MIND_STONE.get().getItem(), title(LibAdvancements.HEAR_ME_HEARTBEAT), description(LibAdvancements.HEAR_ME_HEARTBEAT),
                        SaintChapter.key("textures/block/mind_stone.png"),
                        FrameType.TASK, true, true, false)
                .withCriterion(LibAdvancements.HEAR_ME_HEARTBEAT + "_in_inventory", InventoryChangeTrigger.Instance.forItems(RegistryItems.RegistryBlockItems.MIND_STONE.get().getItem()))
                .register(registrar, SaintChapter.key(LibAdvancements.HEAR_ME_HEARTBEAT).toString());

        Advancement i_will_tell_you = Advancement.Builder.builder()
                .withDisplay(RegistryItems.MIND_CRYSTAL.get(), title(LibAdvancements.I_WILL_TELL_YOU), description(LibAdvancements.I_WILL_TELL_YOU),
                        null, FrameType.TASK, true, true, false)
                .withCriterion(LibAdvancements.I_WILL_TELL_YOU + "_in_inventory", InventoryChangeTrigger.Instance.forItems(RegistryItems.MIND_CRYSTAL.get()))
                .withParent(heart_me_heartbeat)
                .withRewards(AdvancementRewards.Builder.experience(100).addRecipe(LibRecipes.BOOK_OF_TRUTH).build())
                .register(registrar, SaintChapter.key(LibAdvancements.I_WILL_TELL_YOU).toString());
    }

    private Path getPath(Path base, Advancement advancement) {
        return base.resolve(String.format("data/%s/advancements/%s.json", advancement.getId().getNamespace(), advancement.getId().getPath()));
    }

    private TranslationTextComponent title(String key) {
        return new TranslationTextComponent(String.format("advancement.saintchapter.%s.title", key));
    }

    private TranslationTextComponent description(String key) {
        return new TranslationTextComponent(String.format("advancement.saintchapter.%s.description", key));
    }
}
