package br.com.erp.educacional.infrastructure.database.repository;

import br.com.erp.educacional.domain.entity.contato.Contato;
import br.com.erp.educacional.domain.repository.contato.ContatoRepository;
import br.com.erp.educacional.infrastructure.database.model.ContatoModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

public class ContatoRepositoryJPA implements ContatoRepository {
    @PersistenceContext
    private EntityManager em;


    @Override
    @Transactional
    public void save(Contato contato)
    {
        ContatoModel contatoModel = new ContatoModel();
        contatoModel.setEmail1(contato.getEmail1());
        contatoModel.setTelefone1(contato.getTelefone1());
        contatoModel.setEmail2(contato.getEmail2());
        contatoModel.setTelefone2(contato.getTelefone2());
        contatoModel.setEmail3(contato.getEmail3());
        contatoModel.setTelefone3(contato.getTelefone3());
        em.persist(contatoModel);
    }
}
