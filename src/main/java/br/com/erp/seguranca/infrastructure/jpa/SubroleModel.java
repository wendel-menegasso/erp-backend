package br.com.erp.seguranca.infrastructure.jpa;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "subroles")
@Getter
public class SubroleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String endpoint;
}

