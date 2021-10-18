package net.writingwithfire.saintchapter.common.capability;

import net.minecraft.nbt.CompoundNBT;

public class MindCapability implements IMindCapability{
    private int mindStrength;

    public MindCapability(int mindStrength) {
        this.mindStrength = mindStrength;
    }

    @Override
    public int getMindStrength() {
        return mindStrength;
    }

    @Override
    public void setMindStrength(int mindStrength) {
        this.mindStrength = mindStrength;
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT compoundNBT = new CompoundNBT();
        compoundNBT.putInt("mindStrength", this.mindStrength);
        return compoundNBT;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        this.mindStrength = nbt.getInt("mindStrength");
    }
}
