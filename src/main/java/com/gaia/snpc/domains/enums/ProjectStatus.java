package com.gaia.snpc.domains.enums;

public enum ProjectStatus {

    EN_ATTENTE, VALIDE, EN_EXECUTION, CLOTURE, REJETE;

    public boolean isEnAttente() {
        return this == EN_ATTENTE;
    }
    public boolean isValide() {
        return this == VALIDE;
    }
    public boolean isEnExecution() {
        return this == EN_EXECUTION;
    }
    public boolean isCloture() {
        return this == CLOTURE;
    }
    public boolean isRejete() {
        return this == REJETE;
    }
}
