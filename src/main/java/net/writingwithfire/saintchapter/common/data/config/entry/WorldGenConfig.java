package net.writingwithfire.saintchapter.common.data.config.entry;

import net.minecraftforge.common.ForgeConfigSpec;
import net.writingwithfire.saintchapter.common.data.config.base.ConfigEntry;

public class WorldGenConfig extends ConfigEntry {

    public static final WorldGenConfig CONFIG = new WorldGenConfig();

    private WorldGenConfig() {
        super("worldgen");
    }

    @Override
    public void createEntries(ForgeConfigSpec.Builder cfgBuilder) {}
}
