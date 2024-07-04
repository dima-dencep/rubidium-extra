package me.flashyreese.mods.sodiumextra.mixin;

import com.llamalad7.mixinextras.utils.MixinInternals;
import me.flashyreese.mods.sodiumextra.client.SodiumExtraClientMod;
import net.caffeinemc.caffeineconfig.AbstractCaffeineConfigMixinPlugin;
import net.caffeinemc.caffeineconfig.CaffeineConfig;
import org.spongepowered.asm.mixin.transformer.ext.IExtension;

public class SodiumExtraMixinConfigPlugin extends AbstractCaffeineConfigMixinPlugin {

    private static final String MIXIN_PACKAGE_ROOT = "me.flashyreese.mods.sodiumextra.mixin.";
    public static boolean EMBEDDIUM_HACKED = false;

    static {
        System.setProperty("embeddium.mixinTaintEnforceLevel", "WARN");

        for (IExtension extension : MixinInternals.getExtensions().getActiveExtensions()) {
            String extensionClass = extension.getClass().getName();

            SodiumExtraClientMod.LOGGER.info("Try {}...", extensionClass);

            if (extensionClass.contains(".embeddium.")) {
                MixinInternals.unregisterExtension(extension);
                EMBEDDIUM_HACKED = true;
                SodiumExtraClientMod.LOGGER.info("Embeddium hacked!");
                break;
            }
        }

        if (!EMBEDDIUM_HACKED) {
            SodiumExtraClientMod.LOGGER.error("Embeddium NOT hacked!");
        }
    }

    @Override
    protected CaffeineConfig createConfig() {
        return SodiumExtraClientMod.mixinConfig();
    }

    @Override
    protected String mixinPackageRoot() {
        return MIXIN_PACKAGE_ROOT;
    }
}
