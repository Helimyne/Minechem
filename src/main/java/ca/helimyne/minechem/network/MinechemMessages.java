package ca.helimyne.minechem.network;

import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public class MinechemMessages{

    public static SimpleNetworkWrapper INSTANCE;

    public static void registerNetworkMessages(SimpleNetworkWrapper net){
        INSTANCE = net;

        // Server Side
        net.registerMessage();
    }

}
