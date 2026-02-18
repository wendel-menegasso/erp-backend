package br.com.erp.educacional.domain.repository.common;

import br.com.erp.educacional.domain.entity.commons.Endereco;

import java.util.Optional;

public interface EnderecoRepository {
    void save(Endereco endereco);
    Optional<Endereco> findById(Integer id);
    void remove(Endereco endereco);
    int count();
}
