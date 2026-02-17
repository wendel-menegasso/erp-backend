package br.com.erp.educacional.infrastructure.database.repository;

import br.com.erp.educacional.domain.entity.commons.Documento;
import br.com.erp.educacional.domain.entity.commons.Endereco;
import br.com.erp.educacional.domain.repository.common.EnderecoRepository;
import br.com.erp.educacional.infrastructure.database.model.DocumentoModel;
import br.com.erp.educacional.infrastructure.database.model.EnderecoModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class EnderecoRepositoryJPA implements EnderecoRepository {
    @PersistenceContext
    private EntityManager em;


    @Override
    @Transactional
    public void save(Endereco endereco) {
        EnderecoModel enderecoModel = new EnderecoModel();
        enderecoModel.setCep(endereco.getCep());
        enderecoModel.setEstado(endereco.getEstado());
        enderecoModel.setCidade(endereco.getCidade());
        enderecoModel.setPais(endereco.getPais());
        enderecoModel.setRua(endereco.getRua());
        enderecoModel.setBairro(endereco.getBairro());
        enderecoModel.setNumero(endereco.getNumero());
        em.persist(enderecoModel);
    }

    @Override
    public Optional<Endereco> findById(Integer id) {
        var query = em.createQuery(
                "SELECT end FROM EnderecoModel end WHERE end.id = :id",
                EnderecoModel.class
        );
        query.setParameter("id", id);

        return query.getResultStream()
                .findFirst()
                .map(this::toDomain);
    }

    private Endereco toDomain(EnderecoModel model) {
        Endereco endereco = new Endereco();
        endereco.setCep(model.getCep());
        endereco.setEstado(model.getEstado());
        endereco.setCidade(model.getCidade());
        endereco.setPais(model.getPais());
        endereco.setRua(model.getRua());
        endereco.setBairro(model.getBairro());
        endereco.setNumero(model.getNumero());
        endereco.setId(model.getId());
        return endereco;
    }
}
