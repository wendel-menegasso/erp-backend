package br.com.erp.seguranca.infrastructure.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class RoleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;


    @ManyToMany(mappedBy = "roles")
    private Set<UserModel> users;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_subroles",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "subrole_id")
    )
    private Set<SubroleModel> subroles = new HashSet<>();
}

