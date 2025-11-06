package com.gaia.snpc.domains.entities;

import lombok.*;
import jakarta.persistence.*;
import com.gaia.snpc.domains.enums.Gender;
import com.gaia.snpc.domains.enums.EnrollmentStatus;

import static com.gaia.snpc.domains.enums.EnrollmentStatus.EN_COURS;

@Getter @Setter
@AllArgsConstructor
@Entity(name = "Producers")
@Table(name = "SNPC_PRODUCER_REGISTRY")
public class Producers extends BaseEntity {

    private String phone;

    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String lastName;

    private String firstName;

    @Column(unique = true)
    private String cniNumber;

    @Column(unique = true)
    private String productCard;

    private String cniDocumentUrl;

    @Column(unique = true)
    private String nationalSnpcID;

    @Enumerated(EnumType.STRING)
    private EnrollmentStatus enrollmentStatus;

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

    public Producers(){
        super();
        setEnrollmentStatus(EN_COURS);
    }
}
