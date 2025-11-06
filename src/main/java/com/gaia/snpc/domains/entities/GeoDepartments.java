package com.gaia.snpc.domains.entities;

import lombok.*;
import jakarta.persistence.*;

import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "GEO_DEPARTMENT")
@Entity(name = "GeoDepartments")
public class GeoDepartments extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(
            nullable = false,
            name = "region_id",
            referencedColumnName = "id")
    private GeoRegions region;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<GeoCommunes> communes;

    public GeoDepartments(String id) {
        super(id);
    }
}
