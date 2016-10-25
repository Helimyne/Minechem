package ca.helimyne.minechem;

import ca.helimyne.minechem.items.ModItems;
import ca.helimyne.minechem.items.manual.GuiMinechemManual;
import mcjty.lib.base.ModBase;
import mcjty.lib.compat.MainCompatHandler;
import mcjty.theoneprobe.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = MRef.MID, name = MRef.MNAME,
     dependencies = "required-after:Forge@["+MRef.MIN_FORGE_VER+
     ",);required-after:McJtyLib@["+MRef.MIN_MCJTYLIB_VER+",)",
     version = MRef.MVERSION,
     acceptedMinecraftVersions = "[1.10,1.11)")
public class Minechem implements ModBase{

    @SidedProxy(clientSide = MRef.CLIENT_PROXY, serverSide = MRef.SERVER_PROXY)
    public static CommonProxy proxy;

    @Mod.Instance(MRef.MID)
    public static Minechem instance;




    // This is used to keep track of GUIs that are made
    private static int modGuiIndex = 0;

    public ClientInfo clientInfo = new ClientInfo();

    @Override
    public String getModId(){
        return MRef.MID;
    }

    public static CreativeTabs tabMinechem = new CreativeTabs(){
        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem(){
            return ModItems.minenchemManualItem;
        }
    };

    public static final String SHIFT_MESSAGE = "<Press Shift>";

    // Set our custom inventory Gui index to the next available Gui index.
    public static final int GUI_MANUAL_MAIN = modGuiIndex++;

/**
 * Run before anything else. Read your config, create blocks, items, etc, and
 * register them with the GameRegistry.
 */
@Mod.EventHandler
public void preInit(FMLPostInitializationEvent e){
    this.proxy.preInit(e);
    MainCompatHandler.registerWaila();
    MainCompatHandler.registerTOP();
}
    @Override
    public void openManual(EntityPlayer player, int bookindex, String page){
        GuiMinechemManual.locatePage = page;
        player.openGui(Minechem.instance, bookindex, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);
    }
}
