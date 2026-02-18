package br.com.erp.educacional.infrastructure.database.repository;

import br.com.erp.educacional.domain.entity.contato.Contato;
import br.com.erp.educacional.domain.entity.curso.Curso;
import br.com.erp.educacional.domain.repository.curso.CursoRepository;
import br.com.erp.educacional.infrastructure.database.model.ContatoModel;
import br.com.erp.educacional.infrastructure.database.model.CursoModel;
import br.com.erp.educacional.infrastructure.database.model.DocumentoModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
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

    @Override
    public List<Curso> findAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CursoModel> cq = cb.createQuery(CursoModel.class);
        Root<CursoModel> root = cq.from(CursoModel.class);
        cq.select(root);
        List<Curso> cursos = new ArrayList<>();
        for (CursoModel cursoModel: em.createQuery(cq).getResultList()) {
            Curso curso = new Curso();
            curso.setId(cursoModel.getId());
            curso.setNome(cursoModel.getNome());
            curso.setPeriodo(cursoModel.getPeriodo());
            cursos.add(curso);
        }
        return cursos;
    }

    private Curso toDomain(CursoModel model) {
        Curso curso = new Curso();
        curso.setNome(model.getNome());
        curso.setPeriodo(model.getPeriodo());
        curso.setId(model.getId());
        return curso;
    }
}
