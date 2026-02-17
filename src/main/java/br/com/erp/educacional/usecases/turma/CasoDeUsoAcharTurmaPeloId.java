package br.com.erp.educacional.usecases.turma;

import br.com.erp.educacional.domain.entity.turma.Turma;
import br.com.erp.educacional.domain.repository.turma.TurmaRepository;

public class CasoDeUsoAcharTurmaPeloId {
    private final TurmaRepository repository;

    public CasoDeUsoAcharTurmaPeloId(TurmaRepository repository) {
        this.repository = repository;
    }

    public Turma execute(Integer id) {
        return repository.findById(id).orElseGet(Turma::new);
    }
}
