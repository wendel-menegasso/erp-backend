package br.com.erp.educacional.adapter.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentoDto {
    private String RG;
    private String CPF;
    private String CarteiraDeTralho;
    private String Reservista;
    private String TituloDeEleitor;
    private String OAB;
    private String CREA;
}
