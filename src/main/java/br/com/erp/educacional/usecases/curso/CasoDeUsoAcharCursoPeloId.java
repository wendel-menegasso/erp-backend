package br.com.erp.educacional.usecases.curso;

import br.com.erp.educacional.domain.entity.curso.Curso;
import br.com.erp.educacional.domain.repository.curso.CursoRepository;

public class CasoDeUsoAcharCursoPeloId {
    private final CursoRepository repository;

    public CasoDeUsoAcharCursoPeloId(CursoRepository repository) {
        this.repository = repository;
    }

    public Curso execute(Integer id)
    {
        return repository.findById(id).orElseGet(Curso::new);
    }
}
