package me.flashyreese.mods.sodiumextra.client;

import me.flashyreese.mods.sodiumextra.client.gui.EmbeddiumExtendedOptions;
import me.flashyreese.mods.sodiumextra.client.gui.SodiumExtraGameOptionPages;
import me.flashyreese.mods.sodiumextra.client.gui.SodiumExtraGameOptions;
import net.caffeinemc.caffeineconfig.CaffeineConfig;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLPaths;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.embeddedt.embeddium.api.OptionGUIConstructionEvent;
import org.embeddedt.embeddium.api.OptionGroupConstructionEvent;
import org.embeddedt.embeddium.api.OptionPageConstructionEvent;
import org.embeddedt.embeddium.api.options.structure.StandardOptions;
import org.embeddedt.embeddium.api.render.chunk.RenderSectionDistanceFilterEvent;
import org.embeddedt.embeddium.api.render.clouds.ModifyCloudRenderingEvent;

@Mod(value = SodiumExtraClientMod.MOD_ID, dist = Dist.CLIENT)
public class SodiumExtraClientMod {
    public static final String MOD_ID = "embeddium_extra";
    public static final Logger LOGGER = LogManager.getLogger("Embeddium Extra");
    private static SodiumExtraGameOptions CONFIG;
    private static CaffeineConfig MIXIN_CONFIG;

    public static SodiumExtraGameOptions options() {
        if (CONFIG == null) {
            CONFIG = loadConfig();
        }

        return CONFIG;
    }

    public static CaffeineConfig mixinConfig() {
        if (MIXIN_CONFIG == null) {
            MIXIN_CONFIG = CaffeineConfig.builder("Sodium Extra").withSettingsKey("embeddium_extra", "sodium-extra:options")
                    .addMixinOption("adaptive_sync", true)
                    .addMixinOption("animation", true)
                    .addMixinOption("biome_colors", true)
                    .addMixinOption("cloud", true)
                    .addMixinOption("compat", true, false)
                    .addMixinOption("fog", true)
                    .addMixinOption("fog_falloff", true)
                    .addMixinOption("gui", true)
                    .addMixinOption("instant_sneak", true)
                    .addMixinOption("light_updates", true)
                    .addMixinOption("optimizations", false)
                    .addMixinOption("optimizations.beacon_beam_rendering", false)
                    .addMixinOption("optimizations.draw_helpers", false)
                    .addMixinOption("optimizations.fast_weather", false)
                    .addMixinOption("particle", true)
                    .addMixinOption("prevent_shaders", true)
                    .addMixinOption("profiler", true)
                    .addMixinOption("reduce_resolution_on_mac", true)
                    .addMixinOption("render", true)
                    .addMixinOption("render.block", true)
                    .addMixinOption("render.block.entity", true)
                    .addMixinOption("render.entity", true)
                    .addMixinOption("sky", true)
                    .addMixinOption("sky_colors", true)
                    //.addMixinOption("sodium", true, true, true)
                    //.addMixinOption("sodium.accessibility", true) in embeddium
                    //.addMixinOption("sodium.fog", true) via api
                    //.addMixinOption("sodium.cloud", true) via api
                    //.addMixinOption("sodium.resolution", true) via api
                    //.addMixinOption("sodium.scrollable_page", true) in embeddium
                    //.addMixinOption("sodium.vsync", true) via api
                    .addMixinOption("stars", true)
                    .addMixinOption("steady_debug_hud", true)
                    .addMixinOption("sun_moon", true)
                    .addMixinOption("toasts", true)

                    .withLogger(SodiumExtraClientMod.LOGGER)
                    .withInfoUrl("https://github.com/FlashyReese/sodium-extra-fabric/wiki/Configuration-File")
                    .build(FMLPaths.CONFIGDIR.get().resolve("sodium-extra.properties"));
        }
        return MIXIN_CONFIG;
    }

    private static SodiumExtraGameOptions loadConfig() {
        return SodiumExtraGameOptions.load(FMLPaths.CONFIGDIR.get().resolve("sodium-extra-options.json").toFile());
    }

    public SodiumExtraClientMod() {
        OptionGUIConstructionEvent.BUS.addListener(event -> {
            event.addPage(SodiumExtraGameOptionPages.animation());
            event.addPage(SodiumExtraGameOptionPages.particle());
            event.addPage(SodiumExtraGameOptionPages.detail());
            event.addPage(SodiumExtraGameOptionPages.render());
            event.addPage(SodiumExtraGameOptionPages.extra());
        });

        OptionPageConstructionEvent.BUS.addListener(event -> {
            if (event.getId().matches(StandardOptions.Pages.QUALITY)) {
                event.addGroup(EmbeddiumExtendedOptions.EFFECTS_GROUP);

            } else if (event.getId().matches(StandardOptions.Pages.GENERAL)) {
                event.addGroup(EmbeddiumExtendedOptions.RESOLUTION_GROUP);
            }
        });

        OptionGroupConstructionEvent.BUS.addListener(event -> {
            if (!event.getId().matches(StandardOptions.Group.WINDOW)) {
                return;
            }

            event.getOptions().replaceAll(option -> {
                if (option.getId() == null || !option.getId().matches(StandardOptions.Option.VSYNC)) {
                    return option;
                }
                return EmbeddiumExtendedOptions.ADAPTIVE_VSYNC;
            });
        });

        RenderSectionDistanceFilterEvent.BUS.addListener(event -> {
            event.setFilter(ExtraRenderSectionDistanceFilter.INSTANCE);
        });

        ModifyCloudRenderingEvent.BUS.addListener(event -> {
            event.setCloudRenderDistance(event.getCloudRenderDistance() * SodiumExtraClientMod.options().extraSettings.cloudDistance / 100);
        });
    }
}
