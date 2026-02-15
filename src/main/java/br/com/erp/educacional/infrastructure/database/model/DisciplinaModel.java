package br.com.erp.educacional.infrastructure.database.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table
public class DisciplinaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private ProfessorModel professor;

    @OneToMany(mappedBy = "disciplina")
    private List<NotaModel> notaModels;

}
