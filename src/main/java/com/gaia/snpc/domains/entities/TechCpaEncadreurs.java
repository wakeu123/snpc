package com.gaia.snpc.domains.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@AllArgsConstructor
@Table(name = "TECH_CPA_ENCADREURS")
@Entity(name = "TechCpaEncadreurs")
public class TechCpaEncadreurs extends BaseEntity {


    @Column(unique = true)
    private String cpaCode;

    private Boolean active;

    private String specialization;

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

    public TechCpaEncadreurs(){
        super();
        setActive(Boolean.TRUE);
    }

}
