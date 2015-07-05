package com.chakha.netherwardmod.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockBean extends BlockBush implements IGrowable {

	protected int maxGrowthStage = 4;
	
	@SideOnly(Side.CLIENT)
    protected IIcon[] iIcon;
	
	public BlockBean() {
		//Basic Block Setup
		setTickRandomly(true);
		float f = 0.5F;
		setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
		setCreativeTab(CreativeTabs.tabMisc);
		setHardness(0.0F);
		setStepSound(soundTypeGrass);
		disableStats();
	}
	
	@Override
    protected boolean canPlaceBlockOn(Block parBlock) {
        return parBlock == Blocks.farmland;
    }
	
	public void incrementGrowStage(World world, Random parRand, int parX, int parY, int parZ) {
        int growStage = world.getBlockMetadata(parX, parY, parZ) + MathHelper.getRandomIntegerInRange(parRand, 2, 5);
        if (growStage > maxGrowthStage)
        	growStage = maxGrowthStage;
        world.setBlockMetadataWithNotify(parX, parY, parZ, growStage, 2);
    }
	
	@Override
    public Item getItemDropped(int p_149650_1_, Random parRand, int parFortune) {
        return Item.getItemFromBlock(this);
    }
	
	@Override
    public int getRenderType() {
        return 1;
    }
	
	@Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int parSide, int parGrowthStage) {
		return iIcon[parGrowthStage];
    }
	
	@Override
    public boolean func_149851_a(World parWorld, int parX, int parY, int parZ, boolean p_149851_5_) {
        return parWorld.getBlockMetadata(parX, parY, parZ) != 4;
    }
	
	@Override
    public boolean func_149852_a(World p_149852_1_, Random parRand, int p_149852_3_, int p_149852_4_, int p_149852_5_) {
		return true;
    }
	
	@Override
    public void func_149853_b(World parWorld, Random parRand, int parX, int parY, int parZ) {
		incrementGrowStage(parWorld, parRand, parX, parY, parZ);
    }
}
