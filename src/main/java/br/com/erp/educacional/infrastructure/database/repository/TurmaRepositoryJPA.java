package br.com.erp.educacional.infrastructure.database.repository;

import br.com.erp.educacional.domain.entity.contato.Contato;
import br.com.erp.educacional.domain.entity.turma.Turma;
import br.com.erp.educacional.domain.repository.turma.TurmaRepository;
import br.com.erp.educacional.infrastructure.database.model.ContatoModel;
import br.com.erp.educacional.infrastructure.database.model.TurmaModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class TurmaRepositoryJPA implements TurmaRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public void save(Turma turma) {
        TurmaModel turmaModel = new TurmaModel();
        turmaModel.setPeriodo(turma.getPeriodo());
        turmaModel.setNome(turma.getNome());
        em.persist(turmaModel);
    }

    @Override
    public Optional<Turma> findById(Integer id) {
        var query = em.createQuery(
                "SELECT tur FROM TurmaModel tur WHERE tur.id = :id",
                TurmaModel.class
        );
        query.setParameter("id", id);

        return query.getResultStream()
                .findFirst()
                .map(this::toDomain);
    }

    @Override
    @Transactional
    public void remove(Turma turma) {
        TurmaModel turmaModel = new TurmaModel();
        turmaModel.setPeriodo(turma.getPeriodo());
        turmaModel.setNome(turma.getNome());
        turmaModel.setId(turma.getId());
        em.persist(turmaModel);
    }

    private Turma toDomain(TurmaModel model) {
        Turma turma = new Turma();
        turma.setNome(model.getNome());
        turma.setPeriodo(model.getPeriodo());
        turma.setId(model.getId());
        return turma;
    }
}
