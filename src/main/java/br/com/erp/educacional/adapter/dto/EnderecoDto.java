package br.com.erp.educacional.adapter.dto;

import br.com.erp.educacional.domain.entity.commons.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDto {
    private Integer id;
    private String rua;
    private String cidade;
    private String bairro;
    private String estado;
    private String pais;
    private String cep;
    private Integer numero;

    public void convert(Endereco endereco) {
        this.bairro = endereco.getBairro();
        this.cep = endereco.getCep();
        this.cidade = endereco.getCidade();
        this.pais = endereco.getPais();
        this.estado = endereco.getEstado();
        this.numero = endereco.getNumero();
        this.rua = endereco.getRua();
    }
}
