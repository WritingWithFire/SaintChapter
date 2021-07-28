package net.writingwithfire.saintchapter.common.data.config.base;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.ModConfig;
import net.writingwithfire.saintchapter.common.data.config.CommonConfig;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.function.Consumer;

public abstract class ConfigEntry implements Consumer<ForgeConfigSpec.Builder> {

    private final Set<ConfigEntry> subSections = new HashSet<>();
    private final String path;

    private String subPath = "";
    private ModConfig.Type configType;

    public ConfigEntry(String section) {
        this.path = section.toLowerCase(Locale.ROOT);
    }

    public ConfigEntry newSubSection(ConfigEntry entry) {
        entry.subPath = this.getPath();
        entry.setConfigType(this.configType);
        this.subSections.add(entry);
        return entry;
    }

    final void setConfigType(ModConfig.Type type) {
        this.configType = type;
        this.subSections.forEach(section -> section.setConfigType(type));
    }

    @Override
    public final void accept(ForgeConfigSpec.Builder builder) {
        this.createEntries(builder);

        for (ConfigEntry section : subSections) {
            List<String> splitPath = CommonConfig.DOT_SPLITTER.splitToList(section.getPath());
            builder.push(splitPath);
            section.accept(builder);
            builder.pop(splitPath.size());
        }
    }

    protected String translationKey(String key) {
        return String.format("config.%s.%s.%s", this.configType.extension(), this.getFullPath(), key);
    }

    public abstract void createEntries(ForgeConfigSpec.Builder cfgBuilder);

    public String getPath() {
        return this.path;
    }

    public String getFullPath() {
        return this.subPath.isEmpty() ? getPath() : String.format("%s.%s", this.subPath, getPath());
    }


}
