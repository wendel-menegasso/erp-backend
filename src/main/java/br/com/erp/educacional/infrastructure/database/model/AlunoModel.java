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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "enderecos_id", referencedColumnName = "id")
    private EnderecoModel enderecos;
;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contatos_id", referencedColumnName = "id")
    private ContatoModel contatos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "documento_id", referencedColumnName = "id")
    private DocumentoModel documentos;

    private int numeroDeMatricula;
    private boolean bolsista;

    private int curso;

    private int valorBolsa;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "turma_id")
    private TurmaModel turma;

    @OneToMany(mappedBy = "aluno")
    private List<NotaModel> notaModels;
}
