package br.com.erp.educacional.infrastructure.database.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

;

@Entity
@Getter
@Setter
@Table
public class NotaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private AlunoModel aluno;

    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private DisciplinaModel disciplina;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private ProfessorModel professor;

    private int peso;
    private double nota;
}
