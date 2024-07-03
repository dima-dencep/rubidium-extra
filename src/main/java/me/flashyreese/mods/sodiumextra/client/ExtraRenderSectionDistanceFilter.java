package me.flashyreese.mods.sodiumextra.client;

import net.minecraft.client.MinecraftClient;
import org.embeddedt.embeddium.api.render.chunk.RenderSectionDistanceFilter;

public class ExtraRenderSectionDistanceFilter implements RenderSectionDistanceFilter {
    public static ExtraRenderSectionDistanceFilter INSTANCE = new ExtraRenderSectionDistanceFilter();

    private ExtraRenderSectionDistanceFilter() {

    }

    @Override
    public boolean isWithinDistance(float xDistance, float yDistance, float zDistance, float maxDistance) {
        int fogDistance = SodiumExtraClientMod.options().renderSettings.multiDimensionFogControl ?
                SodiumExtraClientMod.options().renderSettings.dimensionFogDistanceMap.getOrDefault(MinecraftClient.getInstance().world.getDimension().effects(), 0) :
                SodiumExtraClientMod.options().renderSettings.fogDistance;
        if (fogDistance == 33)
            return ((xDistance * xDistance) + (zDistance * zDistance)) < (maxDistance * maxDistance);
        else
            return RenderSectionDistanceFilter.DEFAULT.isWithinDistance(xDistance, yDistance, zDistance, maxDistance);
    }
}
