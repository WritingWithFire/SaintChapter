package net.writingwithfire.saintchapter.common.data.config.base;

import com.google.common.base.Splitter;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.config.ModConfig;
import net.writingwithfire.saintchapter.SaintChapter;

import java.util.ArrayList;
import java.util.List;

public class BaseConfiguration {

    public static final String FILE_SEPARATOR = System.getProperty("file.separator");
    public static final Splitter DOT_SPLITTER = Splitter.on(".");

    private final List<ConfigEntry> configEntries = new ArrayList<>();

    private final ModConfig.Type configType;

    protected BaseConfiguration(ModConfig.Type configType) {
        this.configType = configType;
    }

    public <T extends ConfigEntry> T addConfigEntry(T configEntry) {
        configEntry.setConfigType(this.configType);
        configEntries.add(configEntry);
        return configEntry;
    }

    public void buildConfiguration() {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        for (ConfigEntry entry : configEntries) {
            List<String> splitPath = DOT_SPLITTER.splitToList(entry.getPath());
            builder.push(splitPath);
            entry.accept(builder);
            builder.pop(splitPath.size());
        }

        makeAndRegister(this.configType, builder.build(), SaintChapter.MODID);
    }

    static void makeAndRegister(ModConfig.Type type, ForgeConfigSpec spec, String file) {
        String fileName = type == ModConfig.Type.SERVER ?
                String.format("%s.toml", file) :
                String.format("%s-%s.toml", file, type.extension());
        ModContainer ct = SaintChapter.getModContainer();
        ModConfig cfg = new ModConfig(type, spec, ct, fileName);
        ct.addConfig(cfg);
    }

}
