package br.com.erp.educacional.adapter.dto;

import br.com.erp.educacional.domain.entity.commons.Periodo;
import br.com.erp.educacional.domain.entity.turma.Turma;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TurmaDto {
    private String nome;
    private Periodo periodo;

    public void convert(Turma turma) {
        this.nome = turma.getNome();
        this.periodo = turma.getPeriodo();
    }

}
