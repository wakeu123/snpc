package com.gaia.snpc.domains.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "UserAccounts")
@Table(name = "APP_USER_ACCOUNTS")
public class UserAccounts extends BaseEntity {

    @Column(unique = true)
    private String email;

    private String phone;

    private String displayName;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserRoles> roles;

    // TODO add external_auth_user_id key
}
