package br.com.erp.educacional.adapter.dto;

import br.com.erp.educacional.domain.entity.contato.Contato;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContatoDto {
    private Integer id;
    private String telefone1;
    private String telefone2;
    private String telefone3;
    private String email1;
    private String email2;
    private String email3;

    public void convert(Contato contato) {
        this.email1 = contato.getEmail1();
        this.email2 = contato.getEmail2();
        this.email3 = contato.getEmail3();
        this.telefone1 = contato.getTelefone1();
        this.telefone2 = contato.getTelefone2();
        this.telefone3 = contato.getTelefone3();
    }

}
