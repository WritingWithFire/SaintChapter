package net.writingwithfire.saintchapter.common.capability;

import net.minecraft.nbt.CompoundNBT;

import javax.annotation.Nullable;

public class SoulCapability implements ISoulCapability{
    private int soulStrength;
    private boolean initialized;

    public SoulCapability(int soulStrength, boolean isInitialized) {
        this.soulStrength = soulStrength;
        this.initialized = isInitialized;
    }

    @Override
    public boolean getInitialized() {
        return this.initialized;
    }

    @Override
    public void setInitialized(boolean isInitialize) {
        this.initialized = isInitialize;
    }

    @Override
    public int getSoulStrength() {
        return soulStrength;
    }

    @Override
    public void setSoulStrength(float soulStrength) {
        this.soulStrength = (int) soulStrength;
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT compoundNBT = new CompoundNBT();
        compoundNBT.putInt("soulStrength", this.soulStrength);
        compoundNBT.putBoolean("initialized", this.initialized);
        return compoundNBT;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        this.soulStrength = nbt.getInt("soulStrength");
        this.initialized = nbt.getBoolean("initialized");
    }
}
