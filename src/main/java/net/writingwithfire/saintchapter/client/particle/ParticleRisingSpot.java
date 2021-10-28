package net.writingwithfire.saintchapter.client.particle;

import net.minecraft.client.particle.IAnimatedSprite;
import net.minecraft.client.particle.RisingParticle;
import net.minecraft.client.particle.SpriteTexturedParticle;
import net.minecraft.client.world.ClientWorld;

public class ParticleRisingSpot extends RisingParticle {
    protected ParticleRisingSpot(ClientWorld world, double x, double y, double z, float defaultMotionMultX, float defaultMotionMultY, float defaultMotionMultZ, double motionX, double motionY, double motionZ, float scale, IAnimatedSprite spriteWithAge, float colorMult, int maxAge, double yAccel, boolean canCollide) {
        super(world, x, y, z, defaultMotionMultX, defaultMotionMultY, defaultMotionMultZ, motionX, motionY, motionZ, scale, spriteWithAge, colorMult, maxAge, yAccel, canCollide);
    }
}
