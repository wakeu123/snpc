package com.gaia.snpc.domains.enums;

public enum InvestmentType {

    REBOISEMENT, GESTION_SOLS, HYDRAULIQUE, COMPOSTAGE, AUTRE;

    public boolean isReboisement() {
        return this == REBOISEMENT;
    }
    public boolean isGestionSols() {
        return this == GESTION_SOLS;
    }
    public boolean isHydraulique() {
        return this == HYDRAULIQUE;
    }
    public boolean isCompostage() {
        return this == COMPOSTAGE;
    }
    public boolean isAutre() {
        return this == AUTRE;
    }
}
