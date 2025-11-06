package com.gaia.snpc.domains.enums;

public enum Gender {
    MASCULIN, FEMININ;

    public boolean isMale() {
        return this == MASCULIN;
    }

    public boolean isFemme() {
        return this == FEMININ;
    }
}
