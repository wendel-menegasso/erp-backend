package br.com.erp.educacional.usecases.curso;

import br.com.erp.educacional.adapter.dto.CursoDto;
import br.com.erp.educacional.domain.entity.curso.Curso;
import br.com.erp.educacional.domain.repository.curso.CursoRepository;
import jakarta.persistence.criteria.CriteriaBuilder;

public class CasoDeUsoDeletarCurso {
    private final CursoRepository repository;

    public CasoDeUsoDeletarCurso(CursoRepository repository) {
        this.repository = repository;
    }

    public void execute(CursoDto dto, Integer id)
    {
        Curso curso = new Curso();
        curso.setNome(dto.getNome());
        curso.setPeriodo(dto.getPeriodo());
        curso.setId(id);
    }
}
