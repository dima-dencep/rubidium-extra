package me.flashyreese.mods.sodiumextra.client.gui.options.storage;

import me.flashyreese.mods.sodiumextra.client.SodiumExtraClientMod;
import net.minecraft.util.Identifier;
import org.embeddedt.embeddium.api.options.OptionIdentifier;

public class SodiumExtraOptions {
    public static class Group {
        public static final Identifier EFFECTS = Identifier.of(SodiumExtraClientMod.MOD_ID, "group_effects");
        public static final Identifier RESOLUTIONS = Identifier.of(SodiumExtraClientMod.MOD_ID, "group_resolutions");
        public static final Identifier ANIMATIONS_ALL = Identifier.of(SodiumExtraClientMod.MOD_ID, "group_animations_all");
        public static final Identifier BLOCK_ANIMATIONS = Identifier.of(SodiumExtraClientMod.MOD_ID, "group_block_animations");

        public static final Identifier PARTICLES_ALL = Identifier.of(SodiumExtraClientMod.MOD_ID, "group_particles_all");
        public static final Identifier PARTICLES_BLOCK = Identifier.of(SodiumExtraClientMod.MOD_ID, "group_particles_block");

        public static final Identifier DETAILS_DEFAULT = Identifier.of(SodiumExtraClientMod.MOD_ID, "group_details_default");

        public static final Identifier RENDER_FOG = Identifier.of(SodiumExtraClientMod.MOD_ID, "group_render_fog");
        public static final Identifier RENDER_SINGLE_FOG = Identifier.of(SodiumExtraClientMod.MOD_ID, "group_render_single_fog");
        public static final Identifier RENDER_LIGHT = Identifier.of(SodiumExtraClientMod.MOD_ID, "group_render_light");
        public static final Identifier RENDER_ENTITY = Identifier.of(SodiumExtraClientMod.MOD_ID, "group_render_entity");
        public static final Identifier RENDER_BLOCK_ENTITY = Identifier.of(SodiumExtraClientMod.MOD_ID, "group_render_block_entity");
        public static final Identifier RENDER_TAG_ENTITY = Identifier.of(SodiumExtraClientMod.MOD_ID, "group_render_other_entity");
        public static final Identifier EXTRA_MAC_OS = Identifier.of(SodiumExtraClientMod.MOD_ID, "group_extra_mac_os");
        public static final Identifier EXTRA_OVERLAY = Identifier.of(SodiumExtraClientMod.MOD_ID, "group_extra_overlay");
        public static final Identifier EXTRA_ADVANCED_ITEM_TOOLTIPS = Identifier.of(SodiumExtraClientMod.MOD_ID, "group_extra_advanced_item_tooltips");
        public static final Identifier EXTRA_TOASTS = Identifier.of(SodiumExtraClientMod.MOD_ID, "group_extra_toasts");
        public static final Identifier EXTRA_SHADERS = Identifier.of(SodiumExtraClientMod.MOD_ID, "group_extra_toasts");
        public static final Identifier EXTRA_DEBUG = Identifier.of(SodiumExtraClientMod.MOD_ID, "group_extra_toasts");
    }

    public static class Pages {
        public static final OptionIdentifier<Void> ANIMATIONS = SodiumExtraClientMod.optionIdentifier("animations");
        public static final OptionIdentifier<Void> PARTICLES = SodiumExtraClientMod.optionIdentifier("particles");
        public static final OptionIdentifier<Void> DETAILS = SodiumExtraClientMod.optionIdentifier("details");
        public static final OptionIdentifier<Void> RENDER = SodiumExtraClientMod.optionIdentifier("render");
        public static final OptionIdentifier<Void> EXTRAS = SodiumExtraClientMod.optionIdentifier("extras");
    }

    public static class Option {
        public static final Identifier RESOLUTION = Identifier.of("minecraft", "resolution");

        public static final Identifier ADAPTIVE_VSYNC = Identifier.of(SodiumExtraClientMod.MOD_ID, "vsync");
        public static final Identifier SCREEN_EFFECT_SCALE = Identifier.of(SodiumExtraClientMod.MOD_ID, "screen_effect_scale");
        public static final Identifier FOV_EFFECT_SCALE = Identifier.of(SodiumExtraClientMod.MOD_ID, "fov_effect_scale");

        public static final Identifier ANIMATIONS_ALL = Identifier.of(SodiumExtraClientMod.MOD_ID, "animations_all");
        public static final Identifier ANIMATIONS_WATER = Identifier.of(SodiumExtraClientMod.MOD_ID, "animations_water");
        public static final Identifier ANIMATIONS_LAVA = Identifier.of(SodiumExtraClientMod.MOD_ID, "animations_lava");
        public static final Identifier ANIMATIONS_FIRE = Identifier.of(SodiumExtraClientMod.MOD_ID, "animations_fire");
        public static final Identifier ANIMATIONS_NETHER_PORTAL = Identifier.of(SodiumExtraClientMod.MOD_ID, "animations_nether_portal");
        public static final Identifier ANIMATIONS_BLOCK = Identifier.of(SodiumExtraClientMod.MOD_ID, "animations_block");
        public static final Identifier ANIMATIONS_SCULK_SENSOR = Identifier.of(SodiumExtraClientMod.MOD_ID, "animations_sculk_sensor");

        public static final Identifier PARTICLES_ALL = Identifier.of(SodiumExtraClientMod.MOD_ID, "particles_all");
        public static final Identifier PARTICLES_SPLASH = Identifier.of(SodiumExtraClientMod.MOD_ID, "particles_splash");
        public static final Identifier PARTICLES_BREAK = Identifier.of(SodiumExtraClientMod.MOD_ID, "particles_break");
        public static final Identifier PARTICLES_HIT = Identifier.of(SodiumExtraClientMod.MOD_ID, "particles_hit");
        public static final Identifier PARTICLES_TYPES = Identifier.of(SodiumExtraClientMod.MOD_ID, "particles_types");

        public static final Identifier DETAILS_SKY = Identifier.of(SodiumExtraClientMod.MOD_ID, "details_sky");
        public static final Identifier DETAILS_STARS = Identifier.of(SodiumExtraClientMod.MOD_ID, "details_stars");
        public static final Identifier DETAILS_SUN_MOON = Identifier.of(SodiumExtraClientMod.MOD_ID, "details_sun_moon");
        public static final Identifier DETAILS_WEATHER = Identifier.of(SodiumExtraClientMod.MOD_ID, "details_weather");
        public static final Identifier DETAILS_BIOME_COLORS = Identifier.of(SodiumExtraClientMod.MOD_ID, "details_biome_colors");
        public static final Identifier DETAILS_SKY_COLORS = Identifier.of(SodiumExtraClientMod.MOD_ID, "details_sky_colors");

        public static final Identifier RENDER_FOG_TYPE = Identifier.of(SodiumExtraClientMod.MOD_ID, "render_fog_type");
        public static final Identifier RENDER_FOG_DIMENSION_TYPES = Identifier.of(SodiumExtraClientMod.MOD_ID, "render_fog_dimension_type");
        public static final Identifier RENDER_MULTI_DIMENSION_FOG = Identifier.of(SodiumExtraClientMod.MOD_ID, "render_multi_dimension_fog");
        public static final Identifier RENDER_FOG_FALLOUT = Identifier.of(SodiumExtraClientMod.MOD_ID, "render_fog_falloff");
        public static final Identifier RENDER_SINGLE_FOG = Identifier.of(SodiumExtraClientMod.MOD_ID, "render_single_fog");
        public static final Identifier RENDER_LIGHT_UPDATES = Identifier.of(SodiumExtraClientMod.MOD_ID, "render_light_updates");
        public static final Identifier RENDER_ITEM_FRAME = Identifier.of(SodiumExtraClientMod.MOD_ID, "render_item_frame");
        public static final Identifier RENDER_ARMOR_STAND = Identifier.of(SodiumExtraClientMod.MOD_ID, "render_armor_stand");
        public static final Identifier RENDER_PAINTING = Identifier.of(SodiumExtraClientMod.MOD_ID, "render_painting");
        public static final Identifier RENDER_RENDER_BEACON_BEAM = Identifier.of(SodiumExtraClientMod.MOD_ID, "render_beacon_beam");
        public static final Identifier RENDER_LIMIT_BEACON_BEAM_HEIGHT = Identifier.of(SodiumExtraClientMod.MOD_ID, "render_limit_beacon_beam_height");
        public static final Identifier RENDER_ENCHANTING_TABLE_BOOK = Identifier.of(SodiumExtraClientMod.MOD_ID, "render_enchanting_table_book");
        public static final Identifier RENDER_PISTON = Identifier.of(SodiumExtraClientMod.MOD_ID, "render_piston");
        public static final Identifier RENDER_ITEM_FRAME_NAME_TAG = Identifier.of(SodiumExtraClientMod.MOD_ID, "render_item_frame_name_tag");
        public static final Identifier RENDER_PLAYER_NAME_TAG = Identifier.of(SodiumExtraClientMod.MOD_ID, "render_player_name_tag");

        public static final Identifier EXTRA_REDUCE_RESOLUTION_ON_MAC = Identifier.of(SodiumExtraClientMod.MOD_ID, "extra_reduce_resolution_on_mac");
        public static final Identifier EXTRA_OVERLAY_CORNER = Identifier.of(SodiumExtraClientMod.MOD_ID, "extra_overlay_corner");
        public static final Identifier EXTRA_TEXT_CONTRAST = Identifier.of(SodiumExtraClientMod.MOD_ID, "extra_text_contrast");
        public static final Identifier EXTRA_SHOW_FPS = Identifier.of(SodiumExtraClientMod.MOD_ID, "extra_show_fps");
        public static final Identifier EXTRA_SHOW_FPS_EXTENDED = Identifier.of(SodiumExtraClientMod.MOD_ID, "extra_show_fps_extended");
        public static final Identifier EXTRA_SHOW_COORDINATES = Identifier.of(SodiumExtraClientMod.MOD_ID, "extra_show_coordinates");
        public static final Identifier EXTRA_CLOUD_HEIGHT = Identifier.of(SodiumExtraClientMod.MOD_ID, "extra_cloud_height");
        public static final Identifier EXTRA_CLOUD_DISTANCE = Identifier.of(SodiumExtraClientMod.MOD_ID, "extra_cloud_distance");
        public static final Identifier EXTRA_ADVANCED_ITEM_TOOLTIPS = Identifier.of(SodiumExtraClientMod.MOD_ID, "extra_advanced_item_tooltips");
        public static final Identifier EXTRA_TOASTS = Identifier.of(SodiumExtraClientMod.MOD_ID, "extra_toasts");
        public static final Identifier EXTRA_ADVANCEMENT_TOAST = Identifier.of(SodiumExtraClientMod.MOD_ID, "extra_advancement_toast");
        public static final Identifier EXTRA_RECIPE_TOAST = Identifier.of(SodiumExtraClientMod.MOD_ID, "extra_recipe_toast");
        public static final Identifier EXTRA_SYSTEM_TOAST = Identifier.of(SodiumExtraClientMod.MOD_ID, "extra_system_toast");
        public static final Identifier EXTRA_TUTORIAL_TOAST = Identifier.of(SodiumExtraClientMod.MOD_ID, "extra_tutorial_toast");
        public static final Identifier EXTRA_INSTANT_SNEAK = Identifier.of(SodiumExtraClientMod.MOD_ID, "extra_instant_sneak");
        public static final Identifier EXTRA_PREVENT_SHADERS = Identifier.of(SodiumExtraClientMod.MOD_ID, "extra_prevent_shaders");
        public static final Identifier EXTRA_STEADY_DEBUG_HUD = Identifier.of(SodiumExtraClientMod.MOD_ID, "extra_steady_debug_hud");
        public static final Identifier EXTRA_STEADY_DEBUG_HUD_REFRESH_INTERVAL = Identifier.of(SodiumExtraClientMod.MOD_ID, "extra_steady_debug_hud_refresh_interval");
    }
}
