package br.com.erp.educacional.infrastructure.database.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table
public class AlunoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String pai;
    private String mae;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    private List<EnderecoModel> enderecos;
;

    @OneToOne
    @JoinColumn(name = "contatos_id")
    private ContatoModel contatos;

    @OneToOne
    @JoinColumn(name = "documento_id")
    private DocumentoModel documentos;

    private int numeroDeMatricula;
    private boolean bolsista;

    @OneToOne
    @JoinColumn(name = "curso_id")
    private CursoModel curso;

    private int valorBolsa;

    @OneToOne
    @JoinColumn(name = "turma_id")
    private TurmaModel turma;

    @OneToMany(mappedBy = "aluno")
    private List<NotaModel> notaModels;
}
