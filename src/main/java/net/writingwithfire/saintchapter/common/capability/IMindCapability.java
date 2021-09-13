package net.writingwithfire.saintchapter.common.capability;

import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;

public interface IMindCapability extends INBTSerializable<CompoundNBT> {
    int getMindStrength ();
}
