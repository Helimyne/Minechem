package ca.helimyne.minechem.items.manual;

import ca.helimyne.minechem.Minechem;
import ca.helimyne.minechem.items.GenericMinechemItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class MinechemManualItem extends GenericMinechemItem{

    public MinechemManualItem(String name){
        super(MinechemManualItem);
        setMaxStackSize(1);
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack){
        return 1;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand){
        if(world.isRemote){
            player.openGui(Minechem.instance,);
        }
    }

}
