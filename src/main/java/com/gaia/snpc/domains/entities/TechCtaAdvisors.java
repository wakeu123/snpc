package com.gaia.snpc.domains.entities;

import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@Entity(name = "TechCtaAdvisors")
@Table(name = "TECH_CTA_ADVISORS")
public class TechCtaAdvisors extends BaseEntity {

    @Column(unique = true)
    private String ctaCode;

    private Boolean active;

    private Boolean certified;

    @Column(name = "certification_date")
    private LocalDate certificationDate;

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

    public TechCtaAdvisors() {
        super();
        setActive(Boolean.TRUE);
        setCertified(Boolean.FALSE);
    }
}
