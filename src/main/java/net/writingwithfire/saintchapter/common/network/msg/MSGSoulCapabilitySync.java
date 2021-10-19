package net.writingwithfire.saintchapter.common.network.msg;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.network.NetworkEvent;
import net.writingwithfire.saintchapter.common.lib.LibCapabilities;

import java.util.function.Supplier;

public class MSGSoulCapabilitySync {
    private final int soulStrength;
    private final boolean initialize;

    public MSGSoulCapabilitySync(int soulStrength, boolean initialize) {
        this.soulStrength = soulStrength;
        this.initialize = initialize;
    }
    public static void encodingMSG(MSGSoulCapabilitySync msg, PacketBuffer buffer) {
        buffer.writeInt(msg.soulStrength);
        buffer.writeBoolean(msg.initialize);
    }
    public static MSGSoulCapabilitySync decodingMSG(PacketBuffer buffer) {
        return new MSGSoulCapabilitySync(buffer.readInt(), buffer.readBoolean());
    }
    public static void handle(MSGSoulCapabilitySync msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayerEntity clientPlayer = ctx.get().getSender();
            if (clientPlayer != null) {
                clientPlayer.getCapability(LibCapabilities.SOUL_CAPABILITY).ifPresent((capability -> {
                    capability.setSoulStrength(msg.soulStrength);
                    capability.setInitialized(msg.initialize);
                }));
            }
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
                if (Minecraft.getInstance().player == null) return;
                Minecraft.getInstance().player.getCapability(LibCapabilities.SOUL_CAPABILITY).ifPresent((capability) -> {
                    capability.setSoulStrength(msg.soulStrength);
                    capability.setInitialized(msg.initialize);
                });
            });
        });
        ctx.get().setPacketHandled(true);
    }
}
