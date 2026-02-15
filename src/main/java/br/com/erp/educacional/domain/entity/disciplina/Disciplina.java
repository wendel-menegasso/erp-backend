package br.com.erp.educacional.domain.entity.disciplina;

import br.com.erp.educacional.domain.entity.professor.Professor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Disciplina {
    private int id;
    private String nome;
    private Professor professor;
}
