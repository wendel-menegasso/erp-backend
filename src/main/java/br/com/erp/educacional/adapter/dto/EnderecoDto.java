package br.com.erp.educacional.adapter.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDto {
    private String rua;
    private String cidade;
    private String bairro;
    private String estado;
    private String pais;
    private String cep;
    private Integer numero;
}
