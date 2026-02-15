package br.com.erp.educacional.infrastructure.database.repository;

import br.com.erp.educacional.domain.entity.commons.Endereco;
import br.com.erp.educacional.domain.repository.common.EnderecoRepository;
import br.com.erp.educacional.infrastructure.database.model.EnderecoModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

public class EnderecoRepositoryJPA implements EnderecoRepository {
    @PersistenceContext
    private EntityManager em;


    @Override
    @Transactional
    public void save(Endereco endereco) {
        EnderecoModel enderecoModel = new EnderecoModel();
        enderecoModel.setProfessor(enderecoModel.getProfessor());
        enderecoModel.setCep(enderecoModel.getCep());
        enderecoModel.setEstado(enderecoModel.getEstado());
        enderecoModel.setCidade(enderecoModel.getCidade());
        enderecoModel.setPais(enderecoModel.getPais());
        enderecoModel.setRua(enderecoModel.getRua());
        enderecoModel.setBairro(enderecoModel.getBairro());
        enderecoModel.setNumero(enderecoModel.getNumero());
        enderecoModel.setAluno(enderecoModel.getAluno());
        em.persist(enderecoModel);
    }
}
