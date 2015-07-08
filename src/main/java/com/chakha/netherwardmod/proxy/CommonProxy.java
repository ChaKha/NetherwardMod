package com.chakha.netherwardmod.proxy;

import com.chakha.netherwardmod.NWMain;
import com.chakha.netherwardmod.blocks.BlockBean;
import com.chakha.netherwardmod.items.ItemBean;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class CommonProxy {

	protected int modEntityID = -1;
	
	public static Block blockBean = new BlockBean();
	
	public static Item itemBean = new ItemBean();
	
	public void preInit(FMLPreInitializationEvent event) {
		registerBlocks();
		registerItems();
		registerModEntities();
	}
	
	public void init(FMLInitializationEvent event) {
		
	}
	
	public void postInit(FMLPostInitializationEvent event) {
		
	}
	
	public void registerModEntities() {
		System.out.println("Registering Netherward entities...");
	}
	
	/**
	 * Used to register each individual entity. Called by registerModEntities.
	 */
	public void registerModEntity(Class parEntityClass, String parEntityName) {
	    EntityRegistry.registerModEntity(parEntityClass, parEntityName, ++modEntityID, NWMain.instance, 80, 3, false);
	}
	
	public void registerBlocks() {
		GameRegistry.registerBlock(blockBean, "BlockBean");
	}
	
	public void registerItems() {
		GameRegistry.registerItem(itemBean, "ItemBean");
	}
}
