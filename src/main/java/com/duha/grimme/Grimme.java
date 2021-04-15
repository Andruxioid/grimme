package com.duha.grimme;

import com.duha.grimme.items.ModItems;
import com.duha.grimme.tabs.GrimmeTab;
import com.duha.grimme.utils.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Grimme.MODID, name = Grimme.NAME, version = Grimme.VERSION)
public class Grimme
{
    public static final String MODID = "grimme";
    public static final String NAME = "Grimme Mod";
    public static final String VERSION = "0.1";

    public static Logger logger;
    public static CreativeTabs grimme;

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            ModItems.register(event.getRegistry());
        }
        @SubscribeEvent
        public static void registerItems(ModelRegistryEvent event) {
            ModItems.registerModels();
        }
    }

    public static final GrimmeTab creativeTab = new GrimmeTab();

    @SidedProxy(serverSide = "com.duha.grimme.CommonProxy", clientSide = "com.duha.grimme.ClientProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        proxy.preInit(event);
        logger.info("!Mod preInitialization :" + Reference.NAME);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
        logger.info("!Mod initialization :" + Reference.NAME);
    }
}
