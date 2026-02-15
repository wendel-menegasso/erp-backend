package br.com.erp.educacional.usecases.turma;

import br.com.erp.educacional.adapter.dto.DocumentoDto;
import br.com.erp.educacional.adapter.dto.TurmaDto;
import br.com.erp.educacional.domain.entity.commons.Documento;
import br.com.erp.educacional.domain.entity.turma.Turma;
import br.com.erp.educacional.domain.repository.common.DocumentoRepository;
import br.com.erp.educacional.domain.repository.turma.TurmaRepository;

public class CasoDeUsoCriarTurma {
    private final TurmaRepository repository;

    public CasoDeUsoCriarTurma(TurmaRepository repository) {
        this.repository = repository;
    }

    public void execute(TurmaDto dto) {
        Turma turma = new Turma();
        turma.setNome(dto.getNome());
        turma.setPeriodo(dto.getPeriodo());
        repository.save(turma);
    }
}
