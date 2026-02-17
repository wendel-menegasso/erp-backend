package br.com.erp.educacional.usecases.contato;

import br.com.erp.educacional.domain.entity.contato.Contato;
import br.com.erp.educacional.domain.repository.contato.ContatoRepository;

import java.util.Optional;

public class CasoDeUsoAcharContatoPeloId {
    private final ContatoRepository repository;

    public CasoDeUsoAcharContatoPeloId(ContatoRepository repository) {
        this.repository = repository;
    }

    public Contato execute(Integer id) {
        return repository.findById(id).orElseGet(Contato::new);
    }
}
