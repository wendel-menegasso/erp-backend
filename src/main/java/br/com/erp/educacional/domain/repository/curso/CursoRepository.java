
package br.com.erp.educacional.domain.repository.curso;

import br.com.erp.educacional.domain.entity.curso.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoRepository {
    void save(Curso curso);
    Optional<Curso> findById(Integer id);
    List<Curso> findAll();
}
