package com.gaia.snpc.domains.entities;

import lombok.*;
import jakarta.persistence.*;
import com.gaia.snpc.domains.enums.AppRoles;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "UserRoles")
@Table(name = "APP_USER_ROLES")
public class UserRoles extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AppRoles role;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(
            nullable = false,
            name = "user_id",
            referencedColumnName = "id")
    private UserAccounts user;
}
