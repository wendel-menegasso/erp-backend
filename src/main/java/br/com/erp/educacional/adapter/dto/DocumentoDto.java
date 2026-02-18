package br.com.erp.educacional.adapter.dto;

import br.com.erp.educacional.domain.entity.commons.Documento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentoDto {
    private Integer id;
    private String rg;
    private String cpf;
    private String carteiraDeTralho;
    private String reservista;
    private String tituloDeEleitor;
    private String oab;
    private String crea;

    public void convert(Documento documento) {
        this.rg = documento.getRG();
        this.cpf = documento.getCPF();
        this.carteiraDeTralho = documento.getCarteiraDeTralho();
        this.reservista = documento.getReservista();
        this.tituloDeEleitor = documento.getTituloDeEleitor();
        this.oab = documento.getOAB();
        this.crea = documento.getCREA();
    }
}
