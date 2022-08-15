package me.foksha.togglesneaksprint;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.option.StickyKeyBinding;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ToggleSneakSprint implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("togglesneak-sprint");

	public static KeyBinding keySneakToggle =
			KeyBindingHelper.registerKeyBinding(
					new StickyKeyBinding(
							"key.togglesneak-sprint.sneak",
							GLFW.GLFW_KEY_UNKNOWN,
							"key.categories.movement",
							() -> true
					)
			);

	public static KeyBinding keySprintToggle =
			KeyBindingHelper.registerKeyBinding(
					new StickyKeyBinding(
							"key.togglesneak-sprint.sprint",
							GLFW.GLFW_KEY_UNKNOWN,
							"key.categories.movement",
							() -> true
					)
			);



	@Override
	public void onInitialize() {
		LOGGER.info("Initializing toggle sneak and sprint mod!");
		ClientTickEvents.START_CLIENT_TICK.register(this::onTickStart);

	}

	public void onTickStart(MinecraftClient client) {
		if(keySprintToggle.isPressed() && client.player != null) {
			client.player.setSprinting(true);
		}
	}
}
