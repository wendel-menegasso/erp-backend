package br.com.erp.educacional.usecases.turma;

import br.com.erp.educacional.adapter.dto.TurmaDto;
import br.com.erp.educacional.domain.entity.turma.Turma;
import br.com.erp.educacional.domain.repository.turma.TurmaRepository;

public class CasoDeUsoDeletarTurma {
    private final TurmaRepository repository;

    public CasoDeUsoDeletarTurma(TurmaRepository repository) {
        this.repository = repository;
    }

    public void execute(TurmaDto dto, Integer id) {
        Turma turma = new Turma();
        turma.setNome(dto.getNome());
        turma.setPeriodo(dto.getPeriodo());
        turma.setId(id);
        repository.remove(turma);
    }
}
