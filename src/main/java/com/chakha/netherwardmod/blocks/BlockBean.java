package com.chakha.netherwardmod.blocks;

import java.util.Random;

import com.chakha.netherwardmod.items.ItemBean;
import com.chakha.netherwardmod.proxy.CommonProxy;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockBean extends BlockBush implements IGrowable {

	protected final int MAX_GROWTH_STAGE = 7;
	
    @SideOnly(Side.CLIENT)
    protected IIcon[] iIcon;

    public BlockBean() {
    	// Basic block setup
        setTickRandomly(true);
        float f = 0.5F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
        setCreativeTab(CreativeTabs.tabMisc);
        setHardness(0.0F);
        setStepSound(soundTypeGrass);
        this.setBlockName("BlockBean");
        disableStats();
    }

    @Override
    protected boolean canPlaceBlockOn(Block parBlock) {
        return parBlock == Blocks.farmland;
    }

    public void incrementGrowStage(World parWorld, Random parRand, int parX, int parY, int parZ) {
        int growStage = parWorld.getBlockMetadata(parX, parY, parZ) + 1;
        if (growStage > MAX_GROWTH_STAGE)
        	growStage = MAX_GROWTH_STAGE;
        parWorld.setBlockMetadataWithNotify(parX, parY, parZ, growStage, 2);
    }
    
    @Override
    public Item getItemDropped(int p_149650_1_, Random parRand, int parFortune) {
        return CommonProxy.itemBean;
    }

    @Override
    public int getRenderType() {
        return 1; // Cross like flowers
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int parSide, int parGrowthStage) {
    	return iIcon[parGrowthStage];
    }
    
    @Override
    public void updateTick(World parWorld, int parX, int parY, int parZ, Random parRand) {
        super.updateTick(parWorld, parX, parY, parZ, parRand);
        int growStage = parWorld.getBlockMetadata(parX, parY, parZ) + 1;
        if (growStage > MAX_GROWTH_STAGE)
            growStage = MAX_GROWTH_STAGE;
        parWorld.setBlockMetadataWithNotify(parX, parY, parZ, growStage, 2);
    }
    
    @Override
    public int quantityDropped(Random rand) {
        return 1;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister parIIconRegister) {
          iIcon = new IIcon[MAX_GROWTH_STAGE + 1];
          // seems that crops like to have 8 growth icons, but okay to repeat actual texture if you want
          // to make generic should loop to maxGrowthStage
          iIcon[0] = parIIconRegister.registerIcon("nw:BlockBean_stage_0");
          iIcon[1] = parIIconRegister.registerIcon("nw:BlockBean_stage_1");
          iIcon[2] = parIIconRegister.registerIcon("nw:BlockBean_stage_2");
          iIcon[3] = parIIconRegister.registerIcon("nw:BlockBean_stage_3");
          iIcon[4] = parIIconRegister.registerIcon("nw:BlockBean_stage_4");
          iIcon[5] = parIIconRegister.registerIcon("nw:BlockBean_stage_5");
          iIcon[6] = parIIconRegister.registerIcon("nw:BlockBean_stage_6");
          iIcon[7] = parIIconRegister.registerIcon("nw:BlockBean_stage_7");
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float sideX,
    		float sideY, float sideZ) {
    	if (player.getHeldItem().getItem() == Items.ghast_tear && this.getPlantMetadata(world, x, y, z) == MAX_GROWTH_STAGE) {
    		//Summon plant boss and clear area
    	}
    	//TEMPORARY CODE
    	if (player.getHeldItem().getItem() == Items.golden_hoe && !(this.getPlantMetadata(world, x, y, z) == MAX_GROWTH_STAGE)) {
    		world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) + 1, 2);
    	}
    	return true;
    }
   
    /*
     * Need to implement the IGrowable interface methods
     */
    @Override
    // checks if finished growing
    public boolean func_149851_a(World parWorld, int parX, int parY, int parZ, boolean p_149851_5_) {
        return parWorld.getBlockMetadata(parX, parY, parZ) != MAX_GROWTH_STAGE;
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