package ca.helimyne.minechem;

import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * This Class holds information on client-side only which are global to the mod.
 */

public class ClientInfo{

    private BlockPos selectedTE = null;
    private BlockPos destinationTE = null;

    private BlockPos hilightedBlock = null;
    private long expireHilight = 0;

    public void HilightedBlock(BlockPos c, long expireHilight){
        hilightedBlock = c;
        this.expireHilight = expireHilight;
    }

    public BlockPos getHilightedBlock(){
        return hilightedBlock;
    }

    public long getExpireHilight(){
        return expireHilight;
    }

    public BlockPos getSelectedTE(){
        return selectedTE;
    }

    public void setSelectTE(BlockPos selectedTE){
        this.selectedTE = selectedTE;
    }

    public BlockPos getDestinationTE(){
        return destinationTE;
    }

    public void setDestinationTE(BlockPos destinationTE){
        this.destinationTE = destinationTE;
    }

    @SideOnly(Side.CLIENT)
    public static World getWorld(){
        return Minecraft.getMinecraft().theWorld;
    }
}
