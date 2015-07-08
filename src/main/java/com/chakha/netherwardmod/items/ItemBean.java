package com.chakha.netherwardmod.items;

import com.chakha.netherwardmod.blocks.BlockBean;
import com.chakha.netherwardmod.proxy.CommonProxy;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class ItemBean extends Item implements IPlantable {

	public ItemBean() {
		this.setCreativeTab(getCreativeTab().tabMisc);
		this.setMaxStackSize(1);
		this.setUnlocalizedName("ItemBean");
	}
	
	@Override
	public boolean onItemUse(ItemStack bean, EntityPlayer player, World world, int x, int y, int z, int par7,
			float xFloat, float yFloat, float zFloat) {
		// not sure what this parameter does, copied it from potato
        if (par7 != 1)
            return false;
        else if (player.canPlayerEdit(x, y + 1, z, par7, bean))
            // check that the soil block can sustain the plant
            // and that block above is air so there is room for plant to grow
            if ((world.getBlock(x, y, z).canSustainPlant(world, x, y, z, ForgeDirection.UP, this) && world.isAirBlock(x, y + 1, z))
            		&& (world.canBlockSeeTheSky(x, y + 1, z) && beanAreaCheck(world, x, y, z))) {
	                world.setBlock(x, y + 1, z, CommonProxy.blockBean);
	                // decrement the stack of beans
	                --bean.stackSize;
	                return true;
            } else 
            	return false;
        else
            return false;
	}
	
	public boolean beanAreaCheck(World world, int x, int y, int z) {//WIP ALGORITHM
		for (int xAdd = 0; xAdd < 31; xAdd++) {
			for (int zAdd = 0; zAdd < 31; zAdd++) {
				for (int yAdd = 0; yAdd < 2; yAdd++) {
					Block theBlock = world.getBlock(x + xAdd - 15, y + yAdd, z + zAdd - 15);
					if ((theBlock != Blocks.farmland && theBlock != Blocks.dirt)
							&& (theBlock != Blocks.grass && !world.isAirBlock(x + xAdd - 15, y + yAdd, z + zAdd - 15))
							&& theBlock != CommonProxy.blockBean)
						return false;
				}
				
			}
		}
		return true;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon("nw:" + this.getUnlocalizedName().substring(5));
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
		return EnumPlantType.Crop;
	}

	@Override
	public Block getPlant(IBlockAccess world, int x, int y, int z) {
		return CommonProxy.blockBean;
	}

	@Override
	public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
		return 0;
	}
}