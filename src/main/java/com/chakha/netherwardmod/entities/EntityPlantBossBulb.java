package com.chakha.netherwardmod.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityPlantBossBulb extends EntityMob implements IBossDisplayData {

	public EntityPlantBossBulb(World world) {
		super(world);
		this.setHealth(this.getMaxHealth());
        this.setSize(0.9F, 4.0F);
        this.isImmuneToFire = true;
        this.experienceValue = 50;
        setupAI();
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes(); 
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(160.0D);
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.0D);
		getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0D);
		getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(25.0D);
	}
	
	protected void setupAI() {
		getNavigator().clearPathEntity();
		clearAITasks();
		//TODO
	}
	
	/*@Override
	public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {//TODO
	    if (isEntityInvulnerable())
	        return false;
	    else
	        return super.attackEntityFrom(par1DamageSource, par2);
	}*/
	
	protected void clearAITasks() {
	   tasks.taskEntries.clear();
	   targetTasks.taskEntries.clear();
	}
	
	public void onLivingUpdate() {
		super.onLivingUpdate();
	}
	
	public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEFINED;
    }
	
	@Override
	protected boolean isAIEnabled() {
	   return true;
	}
}
