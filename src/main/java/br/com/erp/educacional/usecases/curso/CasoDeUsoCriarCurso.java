package br.com.erp.educacional.usecases.curso;

import br.com.erp.educacional.domain.entity.curso.Curso;
import br.com.erp.educacional.domain.repository.curso.CursoRepository;

public class CasoDeUsoCriarCurso {
    private final CursoRepository repository;

    public CasoDeUsoCriarCurso(CursoRepository repository) {
        this.repository = repository;
    }

    public void execute(Curso curso)
    {
        repository.save(curso);
    }
}
