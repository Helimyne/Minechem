package ca.helimyne.minechem.proxy;

import ca.helimyne.minechem.GeneralConfiguration;
import ca.helimyne.minechem.MRef;
import ca.helimyne.minechem.network.MinechemMessages;
import mcjty.lib.McJtyLib;
import mcjty.lib.base.GeneralConfig;
import mcjty.lib.network.PacketHandler;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import org.apache.logging.log4j.Level;

import java.io.File;

public abstract class CommonProxy{

    public static File modConfigDir;
    private Configuration mainConfig;

    public void preinit(FMLPreInitializationEvent e){
        McJtyLib.preInit(e);

        GeneralConfig.preInit(e);

        modConfigDir = e.getModConfigurationDirectory();
        mainConfig = new Configuration(new File(modConfigDir.getPath() + File.separator + "minechem", "minechem.cfg"));

        readMainConfig();

        SimpleNetworkWrapper network = PacketHandler.registerMessages(MRef.MID, "minechem");
        MinechemMessages.registerNetworkMessages(network);


    }


    private void readMainConfig(){
        Configuration cfg = mainConfig;
        try{
            cfg.load();
            cfg.addCustomCategoryComment(GeneralConfiguration.CATEGORY_GENERAL, "General settings");



            GeneralConfiguration.init(cfg);

        } catch (Exception e1) {
            FMLLog.log(Level.ERROR, e1, "Problem loading config file!");
        } finally{
            if (mainConfig.hasChanged()){
                mainConfig.save();
            }
        }

    }

}
