package com.gaia.snpc.domains.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@AllArgsConstructor
@Entity(name = "FinanceEmfInstitutions")
@Table(name = "FINANCE_EMF_INSTITUTIONS")
public class FinanceEmfInstitutions extends BaseEntity {

    private String phone;

    private String email;

    private Boolean active;

    private String address;

    private String displayName;

    @Column(unique = true)
    private String licenseReference;

    @OneToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(
            nullable = false,
            name = "user_id",
            referencedColumnName = "id")
    private UserAccounts user;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(
            nullable = false,
            name = "commune_id",
            referencedColumnName = "id")
    private GeoCommunes commune;

    public FinanceEmfInstitutions() {
        super();
        setActive(Boolean.TRUE);
    }
}
