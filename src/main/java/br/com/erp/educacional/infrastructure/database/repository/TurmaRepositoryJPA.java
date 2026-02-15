package br.com.erp.educacional.infrastructure.database.repository;

import br.com.erp.educacional.domain.entity.turma.Turma;
import br.com.erp.educacional.domain.repository.turma.TurmaRepository;
import br.com.erp.educacional.infrastructure.database.model.TurmaModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

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
}
