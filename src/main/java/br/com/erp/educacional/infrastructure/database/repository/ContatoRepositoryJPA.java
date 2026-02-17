package br.com.erp.educacional.infrastructure.database.repository;

import br.com.erp.educacional.domain.entity.commons.Documento;
import br.com.erp.educacional.domain.entity.contato.Contato;
import br.com.erp.educacional.domain.repository.contato.ContatoRepository;
import br.com.erp.educacional.infrastructure.database.model.ContatoModel;
import br.com.erp.educacional.infrastructure.database.model.DocumentoModel;
import br.com.erp.educacional.infrastructure.database.model.EnderecoModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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

    @Override
    public Optional<Contato> findById(Integer id) {
        var query = em.createQuery(
                "SELECT con FROM ContatoModel con WHERE con.id = :id",
                ContatoModel.class
        );
        query.setParameter("id", id);

        return query.getResultStream()
                .findFirst()
                .map(this::toDomain);
    }

    private Contato toDomain(ContatoModel model) {
        Contato contato = new Contato();
        contato.setTelefone1(model.getTelefone1());
        contato.setTelefone2(model.getTelefone2());
        contato.setTelefone3(model.getTelefone3());
        contato.setEmail1(model.getEmail1());
        contato.setEmail2(model.getEmail2());
        contato.setEmail3(model.getEmail3());
        contato.setId(model.getId());
        return contato;
    }
}
