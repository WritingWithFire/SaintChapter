package net.writingwithfire.saintchapter.client.data.config.entry;

import net.minecraftforge.common.ForgeConfigSpec;
import net.writingwithfire.saintchapter.common.data.config.base.ConfigEntry;

public class RenderingConfig extends ConfigEntry {

    public static final RenderingConfig CONFIG = new RenderingConfig();

    private RenderingConfig() {
        super("rendering");
    }

    @Override
    public void createEntries(ForgeConfigSpec.Builder cfgBuilder) {

    }
}
