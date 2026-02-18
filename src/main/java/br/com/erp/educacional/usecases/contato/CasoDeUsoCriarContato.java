package br.com.erp.educacional.usecases.contato;

import br.com.erp.educacional.domain.entity.contato.Contato;
import br.com.erp.educacional.domain.repository.contato.ContatoRepository;

public class CasoDeUsoCriarContato {
    private final ContatoRepository contatoRepository;

    public CasoDeUsoCriarContato(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    public int execute(Contato contato) {
        contatoRepository.save(contato);
        return contatoRepository.count();
    }
}
