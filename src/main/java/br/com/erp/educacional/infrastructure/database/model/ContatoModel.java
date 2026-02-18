package br.com.erp.educacional.infrastructure.database.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ContatoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String telefone1;
    private String telefone2;
    private String telefone3;
    private String email1;
    private String email2;
    private String email3;
    @OneToOne
    @JoinColumn(name = "aluno_id", referencedColumnName = "id")
    private AlunoModel aluno;
}
