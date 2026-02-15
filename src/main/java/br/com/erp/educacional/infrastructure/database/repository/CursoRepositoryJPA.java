package br.com.erp.educacional.infrastructure.database.repository;

import br.com.erp.educacional.domain.entity.curso.Curso;
import br.com.erp.educacional.domain.repository.curso.CursoRepository;
import br.com.erp.educacional.infrastructure.database.model.CursoModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

public class CursoRepositoryJPA implements CursoRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void save(Curso curso) {
        CursoModel cursoModel = new CursoModel();
        cursoModel.setNome(curso.getNome());
        cursoModel.setPeriodo(curso.getPeriodo());
        em.persist(cursoModel);
    }
}
