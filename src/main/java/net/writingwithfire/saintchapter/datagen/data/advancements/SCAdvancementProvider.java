package net.writingwithfire.saintchapter.datagen.data.advancements;

import com.google.common.collect.Sets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.data.AdvancementProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;
import net.writingwithfire.saintchapter.SaintChapter;
import net.writingwithfire.saintchapter.common.registry.deferred.gameobjects.RegistryItems;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Set;
import java.util.function.Consumer;

public class SCAdvancementProvider extends AdvancementProvider {

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
        Advancement.Builder.builder()
                .withDisplay(RegistryItems.MIND_STONE.get().getItem(), title("hear_me_heartbeat"), description("hear_me_heartbeat"),
                        SaintChapter.key("textures/block/mind_stone_texture.png"),
                        FrameType.TASK, false, false, false)
                .withCriterion("hear_the_heartbeat", InventoryChangeTrigger.Instance.forItems(RegistryItems.MIND_STONE.get().getItem()))
                .register(registrar, SaintChapter.key("hear_me_heartbeat").toString());
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
