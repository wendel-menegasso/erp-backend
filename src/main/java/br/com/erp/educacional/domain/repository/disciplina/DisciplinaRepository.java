package br.com.erp.educacional.domain.repository.disciplina;

import br.com.erp.educacional.domain.entity.disciplina.Disciplina;

public interface DisciplinaRepository {
    void save(Disciplina disciplina);
    boolean disciplinaExiste(Disciplina disciplina);
}
