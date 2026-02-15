package br.com.erp.educacional.domain.entity.commons;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Documento {
    private int id;
    private String RG;
    private String CPF;
    private String CarteiraDeTralho;
    private String Reservista;
    private String TituloDeEleitor;
    private String OAB;
    private String CREA;
}
