package com.gaia.snpc.domains.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SUPPLY_AGRODEALERS")
@Entity(name = "SupplyAgroDealers")
public class SupplyAgroDealers extends BaseEntity {

    private String phone;

    private String email;

    private String address;

    private Boolean active;

    private String displayName;

    private String specialization;

    @Column(unique = true)
    private String licenseReference;

    @ManyToOne
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

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "agroDealer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SupplyAgrodealerProducts> agrodealerProducts;
}
