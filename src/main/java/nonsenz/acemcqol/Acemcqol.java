package nonsenz.acemcqol;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents;
import nonsenz.acemcqol.config.ModConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Acemcqol implements ModInitializer {
	public static final String MOD_ID = "acemc-qol";
    public static final Logger LOGGER = LoggerFactory.getLogger("acemc-qol");

	@Override
	public void onInitialize() {
		AutoConfig.register(ModConfig.class, JanksonConfigSerializer::new);


		ClientReceiveMessageEvents.ALLOW_GAME.register((message, overlay) -> {
			//LOGGER.info("message - getString(): " + message.getString());

			ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();

			String entropyEarnedMSG = "FISH » You have been given ";
			String fishCaughtMSG = "FISH » You caught a ";
			String crabAppearedMSG = "FISH » You fished up a crab!";

			if (!config.showEntropyGivenMSG && message.getString().contains(entropyEarnedMSG)) {
				return false;
			}

			if (!config.showFishCaughtMSG && message.getString().contains(fishCaughtMSG)) {
				return false;
			}

			if (!config.showCrabAppearedMSG && message.getString().contains(crabAppearedMSG)) {
				return false;
			}

			return true;
		});
	}
}