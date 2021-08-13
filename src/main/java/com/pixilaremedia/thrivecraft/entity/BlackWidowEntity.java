package com.pixilaremedia.thrivecraft.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.PotionEvent;
import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;
import java.util.Random;

public class BlackWidowEntity extends Monster
{
    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(BlackWidowEntity.class, EntityDataSerializers.BYTE);
    private static final float BLACK_WIDOW_SPECIAL_EFFECT_CHANCE = 0.1F;

    public BlackWidowEntity(EntityType<? extends BlackWidowEntity> entity, Level level)
    {
        super(entity, level);
    }

    protected void registerGoals()
    {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(4, new BlackWidowEntity.BlackWidowAttackGoal(this));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new BlackWidowEntity.BlackWidowTargetGoal<>(this, Player.class));
        this.targetSelector.addGoal(3, new BlackWidowEntity.BlackWidowTargetGoal<>(this, IronGolem.class));
    }

    public double getPassengersRidingOffset()
    {
        return this.getBbHeight() * 0.5F;
    }

    protected PathNavigation createNavigation(Level level) {
        return new WallClimberNavigation(this, level);
    }

    protected void defineSynchedData()
    {
        super.defineSynchedData();
        this.entityData.define(DATA_FLAGS_ID, (byte)0);
    }

    public static boolean canBlackWidowSpawn(EntityType<? extends BlackWidowEntity> monster, LevelAccessor levelAccessor, MobSpawnType spawnType, BlockPos pos, Random random)
    {
        return levelAccessor.getBlockState(pos.below()).is(Blocks.STONE) && levelAccessor.getRawBrightness(pos, 0) < 8;
    }

    public void tick()
    {
        super.tick();
        if(!this.level.isClientSide)
        {
            this.setClimbing(this.horizontalCollision);
        }
    }

    public static AttributeSupplier.Builder createAttributes()
    {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 16.00).add(Attributes.MOVEMENT_SPEED, 0.3F);
    }

    protected SoundEvent getAmbientSound()
    {
        return SoundEvents.SPIDER_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSource)
    {
        return SoundEvents.SPIDER_HURT;
    }

    protected SoundEvent getDeathSound()
    {
        return SoundEvents.SPIDER_DEATH;
    }

    protected void playStepSound(BlockPos blockPos, BlockState blockState)
    {
        this.playSound(SoundEvents.SPIDER_STEP, 0.15f, 1.0f);
    }

    public boolean onClimbable()
    {
        return this.isClimbing();
    }

    public void makeStuckInBlock(BlockState blockState, Vec3 vec3)
    {
        if(!blockState.is(Blocks.COBWEB))
        {
            super.makeStuckInBlock(blockState, vec3);
        }
    }

    public MobType getMobType()
    {
        return MobType.ARTHROPOD;
    }

    public boolean canBeAffected(MobEffectInstance mobEffectInstance)
    {
        if(mobEffectInstance.getEffect() == MobEffects.POISON)
        {
            PotionEvent.PotionApplicableEvent event = new PotionEvent.PotionApplicableEvent(this, mobEffectInstance);
            MinecraftForge.EVENT_BUS.post(event);
            return event.getResult() == Event.Result.ALLOW;
        }
        return super.canBeAffected(mobEffectInstance);
    }
    public boolean isClimbing()
    {
        return (this.entityData.get(DATA_FLAGS_ID) & 1) != 0;
    }

    public void setClimbing(boolean climbing)
    {
        byte b0 = this.entityData.get(DATA_FLAGS_ID);
        if(climbing)
        {
            b0 = (byte)(b0 | 1);
        } else {
            b0 = (byte)(b0 & -2);
        }

        this.entityData.set(DATA_FLAGS_ID, b0);
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance difficultyInstance, MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag compoundTag)
    {
        spawnGroupData = super.finalizeSpawn(serverLevelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
        if(serverLevelAccessor.getRandom().nextInt(100) == 0)
        {
            Skeleton skeleton =  EntityType.SKELETON.create(this.level);
            skeleton.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0f);
            skeleton.finalizeSpawn(serverLevelAccessor, difficultyInstance, mobSpawnType, (SpawnGroupData)null, (CompoundTag)null);
            skeleton.startRiding(this);
        }

        if(spawnGroupData == null)
        {
            spawnGroupData = new BlackWidowEntity.BlackWidowEffectsGroupData();
            if(serverLevelAccessor.getDifficulty() == Difficulty.HARD && serverLevelAccessor.getRandom().nextFloat() < 0.1F * difficultyInstance.getSpecialMultiplier())
            {
                ((BlackWidowEntity.BlackWidowEffectsGroupData)spawnGroupData).setRandomEffect(serverLevelAccessor.getRandom());
            }
        }

        if(spawnGroupData instanceof BlackWidowEntity.BlackWidowEffectsGroupData)
        {
            MobEffect mobEffect = ((BlackWidowEntity.BlackWidowEffectsGroupData)spawnGroupData).effect;
            if(mobEffect != null)
            {
                this.addEffect(new MobEffectInstance(mobEffect, Integer.MAX_VALUE));
            }
        }

        return spawnGroupData;
    }

    protected float getStandingEyeHeight(Pose pose, EntityDimensions entityDimensions)
    {
        return 0.65F;
    }

    static class BlackWidowAttackGoal extends MeleeAttackGoal
    {
        public BlackWidowAttackGoal(BlackWidowEntity blackWidow)
        {
            super(blackWidow, 1.00, true);
        }

        public boolean canUse()
        {
            return super.canUse() && !this.mob.isVehicle();
        }

        public boolean canContinueToUse()
        {
            float f = this.mob.getBrightness();
            if(f >= 0.5F && this.mob.getRandom().nextInt(100) == 0)
            {
                this.mob.setTarget((LivingEntity)null);
                return false;
            } else {
                return super.canContinueToUse();
            }
        }

        protected double getAttackReachSqr(LivingEntity livingEntity)
        {
            return (double)(4.0F + livingEntity.getBbWidth());
        }
    }

    public static class BlackWidowEffectsGroupData implements SpawnGroupData
    {
        public MobEffect effect;

        public void setRandomEffect(Random randomEffect)
        {
            int i = randomEffect.nextInt(5);
            if(i <= 1)
            {
                this.effect = MobEffects.MOVEMENT_SPEED;
            } else if(i <= 2) {
                this.effect = MobEffects.DAMAGE_BOOST;
            } else if(i <= 3) {
                this.effect = MobEffects.REGENERATION;
            } else if(i <= 4) {
                this.effect = MobEffects.INVISIBILITY;
            }
        }
    }

    static class BlackWidowTargetGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T>
    {
        public  BlackWidowTargetGoal(BlackWidowEntity blackWidow, Class<T> mobClass) {
            super(blackWidow, mobClass, true);
        }

        public boolean canUse()
        {
            float f = this.mob.getBrightness();
            return f >= 0.5F ? false : super.canUse();
        }
    }
}
