package me.foksha.togglesneaksprint.mixin;


import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.foksha.togglesneaksprint.ToggleSneakSprint;

import static me.foksha.togglesneaksprint.ToggleSneakSprint.LOGGER;

@Mixin(InGameHud.class)
public class InGameHudMixin {

    @Inject(method = "render", at = @At("HEAD"))
    private void onRender(MatrixStack matrices, float tickDelta, CallbackInfo info) {

        int width = MinecraftClient.getInstance().getWindow().getScaledWidth();
        int height = MinecraftClient.getInstance().getWindow().getScaledHeight();
        MinecraftClient client = MinecraftClient.getInstance();

        if (ToggleSneakSprint.keySneakToggle.isPressed()) {
            if (ToggleSneakSprint.keySprintToggle.isPressed()) {
                client.textRenderer.draw(matrices, "Sneak is toggled!", width - 110, height - 20, -1);
            } else {
                client.textRenderer.draw(matrices, "Sneak is toggled!", width - 110, height - 10, -1);
            }
        }
            if (ToggleSneakSprint.keySprintToggle.isPressed()) {
                client.textRenderer.draw(matrices, "Sprint is toggled!", width - 110, height - 10, -1);
        }
    }



}