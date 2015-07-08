package com.chakha.netherwardmod.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

public class EntityNWPlantBossMortar extends EntityThrowable {

	private static final int DIRECT_DAMAGE = 14;
	
	public EntityNWPlantBossMortar(World world) {
		super(world);
		setSize(0.75F, 0.75F);
	}
	
	public EntityNWPlantBossMortar(World world, EntityLivingBase entityLiving) {
		super(world, entityLiving);
		setSize(0.75F, 0.75F);
	}

	protected void onImpact(MovingObjectPosition mop) {
		if (mop.typeOfHit == MovingObjectType.ENTITY) {
			mop.entityHit.attackEntityFrom(DamageSource.fallingBlock, DIRECT_DAMAGE);
			//add poison or something?
			overGrow();
		} else if (mop.typeOfHit == MovingObjectType.BLOCK) {
			overGrow();
		}
	}
	
	public void overGrow() {
		
	}
}
