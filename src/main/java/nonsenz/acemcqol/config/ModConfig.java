package nonsenz.acemcqol.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import nonsenz.acemcqol.Acemcqol;

@Config(name = Acemcqol.MOD_ID)
public class ModConfig implements ConfigData {
    public boolean showEntropyGivenMSG = true;
    public boolean showFishCaughtMSG = true;
    public boolean showCrabAppearedMSG = true;
}
