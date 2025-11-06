package com.gaia.snpc.domains.enums;

public enum InfrastructureType {
    SECHAGE, FERMENTATION, STOCKAGE, VENTE;

    public boolean isSechage() {
        return this == SECHAGE;
    }
    public boolean isFermentation() {
        return this == FERMENTATION;
    }
    public boolean isStockage() {
        return this == STOCKAGE;
    }
    public boolean isVente() {
        return this == VENTE;
    }
}
