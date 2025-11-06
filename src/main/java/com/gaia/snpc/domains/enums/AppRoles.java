package com.gaia.snpc.domains.enums;

public enum AppRoles {
    ADMIN, PRODUCTEUR, EMF, AGO, CPA, CTA, COOPERATIVE, COMMUNE;

    public boolean isAdmin() {
        return this == ADMIN;
    }
    public boolean isProducteur() {
        return this == PRODUCTEUR;
    }
    public boolean isEmf() {
        return this == EMF;
    }
    public boolean isAgo() {
        return this == AGO;
    }
    public boolean isCpa() {
        return this == CPA;
    }
    public boolean isCooperative() {
        return this == COOPERATIVE;
    }
    public boolean isCta() {
        return this == CTA;
    }
    public boolean isCommune() {
        return this == COMMUNE;
    }
}
