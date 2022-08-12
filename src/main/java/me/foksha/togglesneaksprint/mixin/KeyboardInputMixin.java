package me.foksha.togglesneaksprint.mixin;

import me.foksha.togglesneaksprint.ToggleSneakSprint;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.input.KeyboardInput;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(KeyboardInput.class)
public abstract class KeyboardInputMixin {

    // Inject into the bottom of the method, setting the sneaking value.
    @Inject(
            method="tick",
            at=@At("TAIL")
    )
    public void tick(boolean slowDown, float f, CallbackInfo ci) {

        MinecraftClient.getInstance().player.input.sneaking = ToggleSneakSprint.keySneakToggle.isPressed() || MinecraftClient.getInstance().options.sneakKey.isPressed();
    }
}