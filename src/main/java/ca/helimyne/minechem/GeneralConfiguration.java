package ca.helimyne.minechem;

import mcjty.lib.varia.Logging;
import net.minecraftforge.common.config.Configuration;

import java.util.HashSet;
import java.util.Set;

public class GeneralConfiguration{
    public static final String CATEGORY_GENERAL = "general";

    public static boolean enableDecomposerRecipe = true;
    public static boolean enableSynthesizerRecipe = true;
    public static boolean enableMicroscopeRecipe = true;
    public static boolean enableBlueprintRecipe = true;

    //Dimensions where Uranium ore can generate.
    private static int[] chemUraniumOre = new int[] { -1, 1};
    public static Set<Integer> oregenDimensions = new HashSet<Integer>();

    //Ore Settings
    public static int oreMinVeinSize = 2;
    public static int oreMaxVeinSize = 5;
    public static int oreMaxVeinCount = 3;
    public static int oreMinHeight = 2;
    public static int oreMaxHeight = 15;
    public static boolean retrogen = true;

    public static void init(Configuration cfg){
        Logging.doLogging = cfg.get(CATEGORY_GENERAL,"logging", Logging.doLogging,
                "If true dump a lot of logging information about various things in Minechem. Useful for debugging.").getBoolean();

        enableDecomposerRecipe = cfg.get(CATEGORY_GENERAL, "enableDecomposerRecipe", enableDecomposerRecipe,
                "Enable the Chemical Decomposer recipe.").getBoolean();
        enableSynthesizerRecipe = cfg.get(CATEGORY_GENERAL, "enableSyhthesizerRecipe", enableSynthesizerRecipe,
                "Enable the Chemical Synthesizer recipe.").getBoolean();
        enableMicroscopeRecipe = cfg.get(CATEGORY_GENERAL, "enableMicroscopeRecipe", enableMicroscopeRecipe,
                "Enable the Microscope recipe.").getBoolean();
        enableBlueprintRecipe = cfg.get(CATEGORY_GENERAL, "enableBlueprintRecipe", enableBlueprintRecipe,
                "Enable the Blueprint Projector recipe.").getBoolean();

        oreMinVeinSize = cfg.get(CATEGORY_GENERAL,"oreMinVeinSize", oreMinVeinSize,
                "Minimum vein size of uranium ores.").getInt();
        oreMaxVeinSize = cfg.get(CATEGORY_GENERAL,"oreMaxVeinSize", oreMaxVeinSize,
                "Maximum vein size of uranium ores.").getInt();
        oreMaxVeinCount = cfg.get(CATEGORY_GENERAL,"oreMinVeinSize", oreMaxVeinCount,
                "Minimum number of veins for uranium ores.").getInt();
        oreMinHeight = cfg.get(CATEGORY_GENERAL,"oreMinHeight", oreMinHeight,
                "Minimum y level for uranium ores.").getInt();
        oreMaxHeight = cfg.get(CATEGORY_GENERAL,"oreMaxHeight", oreMaxHeight,
                "Maxnimum y level for uranium ores.").getInt();
        retrogen = cfg.get(CATEGORY_GENERAL, "retrogen", retrogen,
                "Set to true enable retrogen").getBoolean();

        chemUraniumOre = cfg.get(CATEGORY_GENERAL, "chemUraniumOre", chemUraniumOre,
                "Oregen for Uranium Ore").getIntList();
        for(int i : chemUraniumOre){
            oregenDimensions.add(i);
        }
    }

}
