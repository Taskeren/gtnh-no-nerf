package cn.taskeren.gtnn;

import cn.taskeren.gtnn.common.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = GTNNConst.MODID, name = GTNNConst.MODNAME)
public class GTNN {

	public static Logger logger;

	@SidedProxy(clientSide = "cn.taskeren.gtnn.client.ClientProxy", serverSide = "cn.taskeren.gtnn.common.CommonProxy")
	public static CommonProxy proxy;

	@Mod.Instance
	public static GTNN instance;

	public GTNN() {
	}

	@Mod.EventHandler
	public void onPreInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
		proxy.onPreInit(event);
	}

	@Mod.EventHandler
	public void onInit(FMLInitializationEvent event) {
		proxy.onInit(event);
	}

	@Mod.EventHandler
	public void onPostInit(FMLPostInitializationEvent event) {
		proxy.onPostInit(event);
	}

}
