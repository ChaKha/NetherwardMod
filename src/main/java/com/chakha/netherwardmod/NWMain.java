package com.chakha.netherwardmod;

import com.chakha.netherwardmod.proxy.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = "nw", name = "The Netherward Boss Mod", version = "0.0.1")
public class NWMain {

	@Mod.Instance("nw")
	public static NWMain instance;
	
	@SidedProxy(clientSide = "com.chakha.netherwardmod.proxy.ClientProxy", serverSide = "com.chakha.netherwardmod.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println("The Netherward is pre-initializing...");
		proxy.preInit(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		System.out.println("The Netherward is initializing...");
		proxy.init(event);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		System.out.println("The Netherward is post-initializing...");
		proxy.postInit(event);
	}
}
