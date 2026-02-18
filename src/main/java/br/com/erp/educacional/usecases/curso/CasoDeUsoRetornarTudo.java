package br.com.erp.educacional.usecases.curso;

import br.com.erp.educacional.adapter.dto.CursoDto;
import br.com.erp.educacional.domain.entity.curso.Curso;
import br.com.erp.educacional.domain.repository.curso.CursoRepository;

import java.util.List;

public class CasoDeUsoRetornarTudo {
    private final CursoRepository repository;

    public CasoDeUsoRetornarTudo(CursoRepository repository) {
        this.repository = repository;
    }

    public List<Curso> execute()
    {
        return repository.findAll();
    }
}
