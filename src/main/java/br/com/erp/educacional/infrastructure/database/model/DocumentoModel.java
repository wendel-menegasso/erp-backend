package br.com.erp.educacional.infrastructure.database.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table
public class DocumentoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String RG;
    private String CPF;
    private String CarteiraDeTralho;
    private String Reservista;
    private String TituloDeEleitor;
    private String OAB;
    private String CREA;
}
