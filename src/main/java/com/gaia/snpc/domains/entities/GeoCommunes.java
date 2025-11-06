package com.gaia.snpc.domains.entities;

import lombok.*;
import jakarta.persistence.*;

import java.util.List;
import java.util.ArrayList;

@Getter @Setter
@AllArgsConstructor
@Table(name = "GEO_COMMUNE")
@Entity(name = "GeoCommunes")
public class GeoCommunes extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String codeCommune;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(
            nullable = false,
            name = "department_id",
            referencedColumnName = "id")
    private GeoDepartments department;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "commune", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SupplyAgroDealers> agroDealers;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "commune", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TechCtaAdvisors> ctas;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "commune", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FinanceEmfInstitutions> emfs;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "commune", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Producers> producers;

    public GeoCommunes() {
        super();
        setEmfs(new ArrayList<>());
        setCtas(new ArrayList<>());
        setProducers(new ArrayList<>());
        setAgroDealers(new ArrayList<>());
    }

    public GeoCommunes(String id, String code) {
        super(id);
        setCodeCommune(code);
    }
}
