package br.com.erp.educacional.infrastructure.database.repository;

import br.com.erp.educacional.domain.entity.commons.Documento;
import br.com.erp.educacional.domain.entity.commons.Endereco;
import br.com.erp.educacional.domain.repository.common.EnderecoRepository;
import br.com.erp.educacional.infrastructure.database.model.DocumentoModel;
import br.com.erp.educacional.infrastructure.database.model.EnderecoModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
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

    @Override
    @Transactional
    public void remove(Endereco endereco) {
        EnderecoModel enderecoModel = new EnderecoModel();
        enderecoModel.setCep(endereco.getCep());
        enderecoModel.setEstado(endereco.getEstado());
        enderecoModel.setCidade(endereco.getCidade());
        enderecoModel.setPais(endereco.getPais());
        enderecoModel.setRua(endereco.getRua());
        enderecoModel.setBairro(endereco.getBairro());
        enderecoModel.setNumero(endereco.getNumero());
        enderecoModel.setId(endereco.getId());
        EnderecoModel e = em.find(EnderecoModel.class, enderecoModel.getId());
        em.remove(e);
    }

    @Override
    public int count() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<EnderecoModel> cq = cb.createQuery(EnderecoModel.class);
        Root<EnderecoModel> root = cq.from(EnderecoModel.class);
        cq.select(root);
        int index = em.createQuery(cq).getResultList().size() - 1;
        return em.createQuery(cq).getResultList().get(index).getId();
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
