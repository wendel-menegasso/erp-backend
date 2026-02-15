package br.com.erp.educacional.infrastructure.database.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table
public class ProfessorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String pai;
    private String mae;

    @OneToOne(mappedBy = "professor", cascade = CascadeType.ALL)
    private EnderecoModel enderecos;

    @OneToOne
    @JoinColumn(name = "documento_id")
    private DocumentoModel documentos;

    @OneToOne
    @JoinColumn(name = "contatos_id")
    private ContatoModel contatos;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    private List<TituloModel> titulos;

    private int numeroDeMatricula;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    private List<DisciplinaModel> disciplinas;

    @OneToMany(mappedBy = "professor")
    private List<NotaModel> notaModels;


}
