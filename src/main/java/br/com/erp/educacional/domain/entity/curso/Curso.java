package br.com.erp.educacional.domain.entity.curso;

import br.com.erp.educacional.domain.entity.commons.Periodo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Curso {
    private int id;
    private String nome;
    private Periodo periodo;
}
