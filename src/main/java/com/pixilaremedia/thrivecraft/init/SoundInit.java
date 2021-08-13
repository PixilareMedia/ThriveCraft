package com.pixilaremedia.thrivecraft.init;

import com.pixilaremedia.thrivecraft.Ref;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundInit {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Ref.MODID);

    public static final RegistryObject<SoundEvent> BLACK_WIDOW_AMBIENT = createSound("black_widow.ambient");
    public static final RegistryObject<SoundEvent> BLACK_WIDOW_DEATH = createSound("black_widow.death");
    public static final RegistryObject<SoundEvent> BLACK_WIDOW_HURT = createSound("black_widow.hurt");
    public static final RegistryObject<SoundEvent> BLACK_WIDOW_STEP = createSound("black_widow.step");

    private static RegistryObject<SoundEvent> createSound(String name)
    {
        return SOUNDS.register(name, () -> new SoundEvent(Ref.location(name)));
    }
}
