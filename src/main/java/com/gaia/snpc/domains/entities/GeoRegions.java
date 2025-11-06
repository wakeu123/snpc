package com.gaia.snpc.domains.entities;

import lombok.*;
import jakarta.persistence.*;

import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "GEO_REGION")
@Entity(name = "GeoRegions")
public class GeoRegions extends BaseEntity {

    @Column(unique = true)
    private String code;

    @Column(nullable = false)
    private String name;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<GeoDepartments> departments;
}
