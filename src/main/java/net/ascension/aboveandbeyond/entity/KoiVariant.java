package net.ascension.aboveandbeyond.entity;

import com.mojang.serialization.Codec;

import java.util.Arrays;
import java.util.Comparator;

public enum KoiVariant {
    KOHAKU(0),
    SANKE(1),
    SHOWA(2),
    SHERBERT(3);

    public static final Codec<KoiVariant> CODEC = Codec.INT.xmap(KoiVariant::byID, KoiVariant::getId);
    private static final KoiVariant[] BY_ID = Arrays.stream(values())
        .sorted(Comparator.comparingInt(KoiVariant::getId))
        .toArray(KoiVariant[]::new);
    private final int id;

    KoiVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static KoiVariant byID(int id) {
        return BY_ID[id % BY_ID.length];
    }
}