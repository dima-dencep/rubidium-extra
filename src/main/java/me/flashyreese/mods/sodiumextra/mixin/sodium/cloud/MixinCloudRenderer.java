package me.flashyreese.mods.sodiumextra.mixin.sodium.cloud;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import me.flashyreese.mods.sodiumextra.client.SodiumExtraClientMod;
import org.embeddedt.embeddium.impl.render.immediate.CloudRenderer;
import net.minecraft.client.option.GameOptions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(CloudRenderer.class)
public class MixinCloudRenderer {
    @WrapOperation(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/option/GameOptions;getClampedViewDistance()I"))
    public int modifyCloudRenderDistance(GameOptions instance, Operation<Integer> original) {
        return original.call(instance) * SodiumExtraClientMod.options().extraSettings.cloudDistance / 100;
    }
}