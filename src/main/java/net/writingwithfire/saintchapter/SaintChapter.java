package net.writingwithfire.saintchapter;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.writingwithfire.saintchapter.client.ClientProxy;
import net.writingwithfire.saintchapter.common.CommonProxy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("saintchapter")
public class SaintChapter {

    public static final String MODID = "saintchapter";
    public static final String NAME = "Saint Chapter";

    private static SaintChapter instance;
    private static ModContainer modContainer;
    private final CommonProxy proxy;

    public static final Logger LOGGER = LogManager.getLogger();

    public SaintChapter() {
        instance = this;
        modContainer = ModList.get().getModContainerById(MODID).get();

        this.proxy = DistExecutor.unsafeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);
        this.proxy.initialize();
        this.proxy.attachLifecycle(FMLJavaModLoadingContext.get().getModEventBus());
        this.proxy.attachEventHandlers(MinecraftForge.EVENT_BUS);
    }

    public static SaintChapter getInstance() {
        return instance;
    }

    public static ModContainer getModContainer() {
        return modContainer;
    }

    public static CommonProxy getProxy() {
        return getInstance().proxy;
    }

    public static ResourceLocation key(String path) {
        return new ResourceLocation(SaintChapter.MODID, path);
    }

    public static boolean isDoingDataGeneration() {
        return DatagenModLoader.isRunningDataGen();
    }
}
