package com.chakha.netherwardmod.items;

import com.chakha.netherwardmod.blocks.BlockBean;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBean extends Item {

	public ItemBean() {
		this.setCreativeTab(getCreativeTab().tabMisc);
		this.setMaxStackSize(1);
		this.setUnlocalizedName("ItemBean");
	}
	
	@Override
	public boolean onItemUse(ItemStack bean, EntityPlayer player, World world, int x, int y, int z, int par7,
			float xFloat, float yFloat, float zFloat) {
		if (world.getBlock(x, y, z).getUnlocalizedName() == Blocks.farmland.getUnlocalizedName()) {
			if (world.getBlock(x, y + 1, z).getUnlocalizedName() == Blocks.air.getUnlocalizedName()) {
				world.setBlock(x, y + 1, z, BlockBean, 0, 2);
				player.getItemInUse().stackSize--;
				return true;
			}
		}
		return false;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon("nw:" + this.getUnlocalizedName().substring(5));
	}
}