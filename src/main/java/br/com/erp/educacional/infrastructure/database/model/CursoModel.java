package br.com.erp.educacional.infrastructure.database.model;

import br.com.erp.educacional.domain.entity.commons.Periodo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table
public class CursoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private Periodo periodo;
}
