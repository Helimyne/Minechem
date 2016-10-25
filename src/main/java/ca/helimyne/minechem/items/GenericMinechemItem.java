package ca.helimyne.minechem.items;

import ca.helimyne.minechem.Minechem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GenericMinechemItem extends Item{

    public GenericMinechemItem(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Minechem.tabMinechem);
        GameRegistry.register(this);
    }

    @SideOnly(Side.CLIENT)
    public void initModel(){
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
