package com.chakha.netherwardmod.entities;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityNWPlantBossHead extends EntityNWPlantBossPart {

	public EntityNWPlantBossHead(World world) {
		super(world);
	}
	
	public EntityTFHydraHead(EntityNWPlantBoss plantBoss, String s, float f, float f1) {
        super(plantBoss, s, f, f1);
    }
}