package me.flashyreese.mods.sodiumextra.mixin;

import com.llamalad7.mixinextras.utils.MixinInternals;
import me.flashyreese.mods.sodiumextra.client.SodiumExtraClientMod;
import net.caffeinemc.caffeineconfig.AbstractCaffeineConfigMixinPlugin;
import net.caffeinemc.caffeineconfig.CaffeineConfig;
import org.spongepowered.asm.mixin.transformer.ext.IExtension;

public class SodiumExtraMixinConfigPlugin extends AbstractCaffeineConfigMixinPlugin {

    private static final String MIXIN_PACKAGE_ROOT = "me.flashyreese.mods.sodiumextra.mixin.";

    @Override
    protected CaffeineConfig createConfig() {
        return SodiumExtraClientMod.mixinConfig();
    }

    @Override
    protected String mixinPackageRoot() {
        return MIXIN_PACKAGE_ROOT;
    }
}
