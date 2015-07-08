package com.chakha.netherwardmod.entities;

import net.minecraft.entity.EntityCreature;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityNWPlantBossTendril extends EntityCreature {

	EntityNWPlantBoss master;
	
	public EntityNWPlantBossTendril(World world) {
		super(world);
		master = null;
	}
	
	public EntityNWPlantBossTendril(World world, double x, double y, double z) {
		this(world);
	}
	
	public EntityNWPlantBossTendril(World world, EntityNWPlantBoss plantBoss) {
		super(world);
		master = plantBoss;
	}
	
	public boolean attackEntityFrom(DamageSource dmgSrc, float f) {
		//EntityLivingBase prevTarget = func_70638_az();
		if (super.attackEntityFrom(dmgSrc, f)) {
			if (dmgSrc.getEntity() instanceof EntityNWPlantBoss || dmgSrc.getEntity() instanceof EntityNWPlantBossTendril) {
				
			}
			return true;
		} else
			return false;
	}
}
