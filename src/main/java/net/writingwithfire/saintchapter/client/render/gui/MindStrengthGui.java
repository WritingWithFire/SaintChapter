package net.writingwithfire.saintchapter.client.render.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.MainWindow;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.common.util.LazyOptional;
import net.writingwithfire.saintchapter.SaintChapter;
import net.writingwithfire.saintchapter.client.ClientProxy;
import net.writingwithfire.saintchapter.common.capability.IMindCapability;
import net.writingwithfire.saintchapter.common.capability.MindCapability;
import net.writingwithfire.saintchapter.common.lib.LibCapabilities;

import java.util.concurrent.atomic.AtomicInteger;

public class MindStrengthGui extends AbstractGui {
    public static final MindStrengthGui INSTANCE = new MindStrengthGui();

    public static final ResourceLocation MIND_STRENGTH_ICON = new ResourceLocation("saintchapter:textures/gui/mind_strength_icon.png");

    public void render(MatrixStack matrixStack, MainWindow window, PlayerEntity playerEntity) {
        AtomicInteger mindStrength = new AtomicInteger(0);
        playerEntity.getCapability(LibCapabilities.MIND_CAPABILITY).ifPresent(capability -> {
            SaintChapter.LOGGER.info(String.valueOf(capability.getMindStrength()));
        });
        Minecraft.getInstance().getTextureManager().bindTexture(MIND_STRENGTH_ICON);
        int scaledWidth = window.getScaledWidth();
        int scaledHeight = window.getScaledHeight();
        int i1 = scaledWidth / 2 - 91;
        int i2 = MathHelper.ceil(mindStrength.get() / 2.0F / 10.0F);
        int j2 = Math.max(10 - (i2 - 2), 3);
        int k1 = scaledHeight - 39;
        for (int l5 = mindStrength.get() - 1; l5 >= 0; --l5) {
            int k4 = MathHelper.ceil((float) (l5 + 1) / 10.0F) - 1;
            int l4 = i1 + l5 % 10 * 8 - 2;
            int i5 = k1 - k4 * j2 - 2;
            blit(matrixStack, l4, i5, 0, 0, 13, 13);
        }
    }
}
