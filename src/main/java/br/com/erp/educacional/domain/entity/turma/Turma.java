package br.com.erp.educacional.domain.entity.turma;

import br.com.erp.educacional.domain.entity.commons.Periodo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Turma {
    private int id;
    private String nome;
    private Periodo periodo;
}
