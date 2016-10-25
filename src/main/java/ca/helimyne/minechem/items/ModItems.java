package ca.helimyne.minechem.items;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public final class ModItems{

    public static MinchemManualItem minenchemManualItem;


    public static void init(){
        setupVariousItems();
    }

    private static void setupVariousItems(){
        minenchemManualItem = new MinchemManualItem();
    }

    @SideOnly(Side.CLIENT)
    public static void initClient() {
        minenchemManualItem.initModel();
    }

}
