package net.writingwithfire.saintchapter.common.capability;

import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;

public interface ISoulCapability extends INBTSerializable<CompoundNBT> {
    int getSoulStrength ();
    void setSoulStrength(int soulStrength);
    boolean getInitialized();
    void setInitialized(boolean initialized);
}
