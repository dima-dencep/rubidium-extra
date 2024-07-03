package me.flashyreese.mods.sodiumextra.client.gui;

import me.flashyreese.mods.sodiumextra.client.gui.options.control.SliderControlExtended;
import me.flashyreese.mods.sodiumextra.client.gui.options.storage.SodiumExtraOptions;
import me.flashyreese.mods.sodiumextra.common.util.ControlValueFormatterExtended;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.util.VideoMode;
import net.minecraft.client.util.Window;
import net.minecraft.text.Text;
import org.embeddedt.embeddium.api.options.control.ControlValueFormatter;
import org.embeddedt.embeddium.api.options.control.CyclingControl;
import org.embeddedt.embeddium.api.options.control.SliderControl;
import org.embeddedt.embeddium.api.options.structure.Option;
import org.embeddedt.embeddium.api.options.structure.OptionGroup;
import org.embeddedt.embeddium.api.options.structure.OptionImpact;
import org.embeddedt.embeddium.api.options.structure.OptionImpl;
import org.embeddedt.embeddium.api.options.structure.OptionStorage;
import org.embeddedt.embeddium.impl.gui.EmbeddiumGameOptionPages;

import java.util.Optional;

public class EmbeddiumExtendedOptions {
    private static final OptionStorage<GameOptions> vanillaOpts = EmbeddiumGameOptionPages.getVanillaOpts();

    public static final Option<?> ADAPTIVE_VSYNC = OptionImpl.createBuilder(SodiumExtraGameOptions.VerticalSyncOption.class, SodiumExtraGameOptionPages.sodiumExtraOpts)
            .setName(Text.translatable("options.vsync"))
            .setId(SodiumExtraOptions.Option.ADAPTIVE_VSYNC)
            .setTooltip(Text.literal(Text.translatable("sodium.options.v_sync.tooltip").getString() + "\n- " + Text.translatable("sodium-extra.option.use_adaptive_sync.name").getString() + ": " + Text.translatable("sodium-extra.option.use_adaptive_sync.tooltip").getString()))
            .setControl((opt) -> new CyclingControl<>(opt, SodiumExtraGameOptions.VerticalSyncOption.class,
                    SodiumExtraGameOptions.VerticalSyncOption.getAvailableOptions()))
            .setBinding((opts, value) -> {
                switch (value) {
                    case OFF -> {
                        opts.extraSettings.useAdaptiveSync = false;
                        vanillaOpts.getData().getEnableVsync().setValue(false);
                    }
                    case ON -> {
                        opts.extraSettings.useAdaptiveSync = false;
                        vanillaOpts.getData().getEnableVsync().setValue(true);
                    }
                    case ADAPTIVE -> {
                        opts.extraSettings.useAdaptiveSync = true;
                        vanillaOpts.getData().getEnableVsync().setValue(true);
                    }
                }
                vanillaOpts.save();
            }, opts -> {
                if (vanillaOpts.getData().getEnableVsync().getValue() && !opts.extraSettings.useAdaptiveSync) {
                    return SodiumExtraGameOptions.VerticalSyncOption.ON;
                } else if (!vanillaOpts.getData().getEnableVsync().getValue() && !opts.extraSettings.useAdaptiveSync) {
                    return SodiumExtraGameOptions.VerticalSyncOption.OFF;
                } else {
                    return SodiumExtraGameOptions.VerticalSyncOption.ADAPTIVE;
                }
            })
            .setImpact(OptionImpact.VARIES)
            .build();

    public static final OptionGroup EFFECTS_GROUP = OptionGroup.createBuilder()
            .setId(SodiumExtraOptions.Group.EFFECTS)
            .add(OptionImpl.createBuilder(int.class, vanillaOpts)
                    .setName(Text.translatable("options.screenEffectScale"))
                    .setId(SodiumExtraOptions.Option.SCREEN_EFFECT_SCALE)
                    .setTooltip(Text.translatable("options.screenEffectScale.tooltip"))
                    .setControl(option -> new SliderControl(option, 0, 100, 1, ControlValueFormatter.percentage()))
                    .setBinding((opts, value) -> opts.getDistortionEffectScale().setValue((double) value / 100.0F), (opts) -> Math.toIntExact(Math.round(opts.getDistortionEffectScale().getValue() * 100.0F)))
                    .setImpact(OptionImpact.LOW)
                    .build()
            )
            .add(OptionImpl.createBuilder(int.class, vanillaOpts)
                    .setName(Text.translatable("options.fovEffectScale"))
                    .setId(SodiumExtraOptions.Option.FOV_EFFECT_SCALE)
                    .setTooltip(Text.translatable("options.fovEffectScale.tooltip"))
                    .setControl(option -> new SliderControl(option, 0, 100, 1, ControlValueFormatter.percentage()))
                    .setBinding((opts, value) -> opts.getFovEffectScale().setValue(Math.sqrt(value / 100.0F)), (opts) -> (int) Math.round(Math.pow(opts.getFovEffectScale().getValue(), 2.0D) * 100.0F))
                    .setImpact(OptionImpact.LOW)
                    .build()
            )
            .build();

    public static final OptionGroup RESOLUTION_GROUP = OptionGroup.createBuilder()
            .setId(SodiumExtraOptions.Group.RESOLUTIONS)
            .add(OptionImpl.createBuilder(int.class, vanillaOpts)
                    .setName(Text.translatable("options.fullscreen.resolution"))
                    .setId(SodiumExtraOptions.Option.RESOLUTION)
                    .setTooltip(Text.translatable("sodium-extra.option.resolution.tooltip"))
                    .setControl(option -> new SliderControlExtended(option, 0, window().getMonitor() != null ? window().getMonitor().getVideoModeCount() : 0, 1, ControlValueFormatterExtended.resolution(), false))
                    .setBinding((options, value) -> {
                        if (window().getMonitor() != null) {
                            if (value == 0) {
                                window().setVideoMode(Optional.empty());
                            } else {
                                window().setVideoMode(Optional.of(window().getMonitor().getVideoMode(value - 1)));
                            }
                        }
                        window().applyVideoMode();
                    }, options -> {
                        if (window().getMonitor() == null) {
                            return 0;
                        } else {
                            Optional<VideoMode> optional = window().getVideoMode();
                            return optional.map((videoMode) -> window().getMonitor().findClosestVideoModeIndex(videoMode) + 1).orElse(0);
                        }
                    })
                    .setImpact(OptionImpact.HIGH)
                    .build())
            .build();

    private static Window window() {
        return MinecraftClient.getInstance().getWindow();
    }
}
