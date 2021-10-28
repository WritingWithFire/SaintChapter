package net.writingwithfire.saintchapter.client.render.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.MainWindow;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.writingwithfire.saintchapter.SaintChapter;
import net.writingwithfire.saintchapter.common.lib.LibCapabilities;
import org.lwjgl.opengl.GL11;

import java.util.concurrent.atomic.AtomicInteger;

public class MindStrengthGui extends AbstractGui {
//    private final MatrixStack matrixStack;
//    private final int scaledWidth;
//    private final int scaledHeight;
//    private final AtomicInteger mindStrength = new AtomicInteger();
    private static final ResourceLocation MIND_STRENGTH_ICON = new ResourceLocation(SaintChapter.MODID, "textures/gui/mind_strength_icon.png");

//    public MindStrengthGui(MatrixStack matrixStack, MainWindow mainWindow) {
//        this.matrixStack = matrixStack;
//        this.scaledWidth = mainWindow.getScaledWidth();
//        this.scaledHeight = mainWindow.getScaledHeight();
//        if (Minecraft.getInstance().player != null) {
//            Minecraft.getInstance().player.getCapability(LibCapabilities.MIND_CAPABILITY).ifPresent(capability -> {
//                mindStrength.set(capability.getMindStrength());
//            });
//        }
//    }

    // 这样会更节省内存
    public static MindStrengthGui INSTANCE = new MindStrengthGui();

    public void render(MatrixStack matrixStack, MainWindow mainWindow) {
        int scaledWidth = mainWindow.getScaledWidth();
        int scaledHeight = mainWindow.getScaledHeight();
        AtomicInteger mindStrength = new AtomicInteger();
        if (Minecraft.getInstance().player != null) {
            Minecraft.getInstance().player.getCapability(LibCapabilities.MIND_CAPABILITY).ifPresent(capability -> {
                mindStrength.set(capability.getMindStrength());
            });
        }
        Minecraft.getInstance().getTextureManager().bindTexture(MIND_STRENGTH_ICON);
        GL11.glEnable(GL11.GL_BLEND);
        int i1 = scaledWidth / 2 - 91;
        int i2 = MathHelper.ceil(mindStrength.get() / 2.0F / 10.0F);
        int j2 = Math.max(10 - (i2 - 2), 3);
        int k1 = scaledHeight - 39;
        for (int l5 = mindStrength.get() - 1; l5 >= 0; --l5) {
            int k4 = MathHelper.ceil((float) (l5 + 1) / 10.0F) - 1;
            int l4 = i1 + l5 % 10 * 8 - 2;
            int i5 = k1 - k4 * j2 - 2;
            blit(matrixStack, l4, i5, 0, 0, 13, 13, 13, 13);
        }
    }
}
