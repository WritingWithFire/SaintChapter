package net.writingwithfire.saintchapter.common.tile;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TranslationTextComponent;
import net.writingwithfire.saintchapter.common.register.SoundEventRegistry;
import net.writingwithfire.saintchapter.common.register.TileEntityTypeRegistry;

public class TileMindStone extends TileEntity implements ITickableTileEntity {
    private static final int MAX_TIME = 6 * 20;
    private int timer = 0;

    public TileMindStone(){
        super(TileEntityTypeRegistry.MIND_STONE.get());
    }

    @Override
    public void tick() {
        if (world != null && world.isRemote) {
            if (timer == MAX_TIME) {
                PlayerEntity playerEntity = world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 10, false);
                // debug
//                TranslationTextComponent translationTextComponent = new TranslationTextComponent("message.hello_block.hello");
                if (playerEntity != null) {
//                    playerEntity.sendStatusMessage(translationTextComponent, false);
                    world.playSound(playerEntity, pos, SoundEventRegistry.HEART_BEAT.get(), SoundCategory.BLOCKS, 10f, 1f);
                }
                timer = 0;
            }
            timer++;
        }
    }
}
