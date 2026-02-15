package br.com.erp.educacional.infrastructure.database.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table
public class EnderecoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String rua;
    private String cidade;
    private String bairro;
    private String estado;
    private String pais;
    private String cep;
    private int numero;

    @OneToOne
    @JoinColumn(name = "aluno_id")
    private AlunoModel aluno;

    @OneToOne
    @JoinColumn(name = "professor_id")
    private ProfessorModel professor;

}
