package net.writingwithfire.saintchapter.common.network.msg;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.network.NetworkEvent;
import net.writingwithfire.saintchapter.SaintChapter;
import net.writingwithfire.saintchapter.common.lib.LibCapabilities;

import java.util.function.Supplier;

public class MSGMindCapabilitySync {
    private final int mindStrength;

    public MSGMindCapabilitySync(int mindStrength) {
        this.mindStrength = mindStrength;

    }

    public static void encodingMSG(MSGMindCapabilitySync msg, PacketBuffer buffer) {
        buffer.writeInt(msg.mindStrength);
    }

    public static MSGMindCapabilitySync decodingMSG(PacketBuffer buffer) {
        return new MSGMindCapabilitySync(buffer.readInt());
    }

    public static void handle(MSGMindCapabilitySync msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            // 从客户端发送到服务端
            ServerPlayerEntity serverPlayer = ctx.get().getSender();
            if (serverPlayer != null) {
                serverPlayer.getCapability(LibCapabilities.MIND_CAPABILITY).ifPresent((capability -> {
                    capability.setMindStrength(msg.mindStrength);
                }));
                SaintChapter.LOGGER.info("客户端的内容已同步到服务端");
            }
            // 从服务端发送到客户端
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
                if (Minecraft.getInstance().player == null) return;
                Minecraft.getInstance().player.getCapability(LibCapabilities.MIND_CAPABILITY).ifPresent((capability -> {
                    capability.setMindStrength(msg.mindStrength);
                }));
                SaintChapter.LOGGER.info("服务端的内容已同步到客户端");
            });
        });
        ctx.get().setPacketHandled(true);
    }
}
