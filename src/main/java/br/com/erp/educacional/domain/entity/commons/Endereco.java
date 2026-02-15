package br.com.erp.educacional.domain.entity.commons;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Endereco {
    private int id;
    private String rua;
    private String cidade;
    private String bairro;
    private String estado;
    private String pais;
    private String cep;
    private int numero;
}
