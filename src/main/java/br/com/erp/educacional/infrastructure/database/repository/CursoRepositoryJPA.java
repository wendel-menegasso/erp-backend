package br.com.erp.educacional.infrastructure.database.repository;

import br.com.erp.educacional.domain.entity.contato.Contato;
import br.com.erp.educacional.domain.entity.curso.Curso;
import br.com.erp.educacional.domain.repository.curso.CursoRepository;
import br.com.erp.educacional.infrastructure.database.model.ContatoModel;
import br.com.erp.educacional.infrastructure.database.model.CursoModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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

    @Override
    public Optional<Curso> findById(Integer id) {
        var query = em.createQuery(
                "SELECT cur FROM CursoModel cur WHERE cur.id = :id",
                CursoModel.class
        );
        query.setParameter("id", id);

        return query.getResultStream()
                .findFirst()
                .map(this::toDomain);
    }

    private Curso toDomain(CursoModel model) {
        Curso curso = new Curso();
        curso.setNome(model.getNome());
        curso.setPeriodo(model.getPeriodo());
        curso.setId(model.getId());
        return curso;
    }
}
