package br.com.erp.educacional.domain.repository.contato;

import br.com.erp.educacional.domain.entity.contato.Contato;

import java.util.Optional;

public interface ContatoRepository {
    void save(Contato contato);
    Optional<Contato> findById(Integer id);
}
