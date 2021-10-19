package net.writingwithfire.saintchapter.common.network;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import net.writingwithfire.saintchapter.SaintChapter;
import net.writingwithfire.saintchapter.common.network.msg.MSGMindCapabilitySync;
import net.writingwithfire.saintchapter.common.network.msg.MSGSoulCapabilitySync;

public class SCPacketHandler {
    private static final String PROTOCOL_VERSION = "0.0.1";
    private static int ID = 0;

    public static int nextID() {
        return ID++;
    }

    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(SaintChapter.MODID, "main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    public static void registerMSG() {
        INSTANCE.registerMessage(
                nextID(),
                MSGMindCapabilitySync.class,
                MSGMindCapabilitySync::encodingMSG,
                MSGMindCapabilitySync::decodingMSG,
                MSGMindCapabilitySync::handle
        );

        INSTANCE.registerMessage(
                nextID(),
                MSGSoulCapabilitySync.class,
                MSGSoulCapabilitySync::encodingMSG,
                MSGSoulCapabilitySync::decodingMSG,
                MSGSoulCapabilitySync::handle
        );
    }
}
