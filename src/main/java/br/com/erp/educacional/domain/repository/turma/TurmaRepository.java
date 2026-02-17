package br.com.erp.educacional.domain.repository.turma;

import br.com.erp.educacional.domain.entity.turma.Turma;

import java.util.Optional;

public interface TurmaRepository {
    void save(Turma turma);
    Optional<Turma> findById(Integer id);
}
