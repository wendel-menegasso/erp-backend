package br.com.erp.educacional.usecases.contato;

import br.com.erp.educacional.adapter.dto.ContatoDto;
import br.com.erp.educacional.domain.entity.contato.Contato;
import br.com.erp.educacional.domain.repository.contato.ContatoRepository;

public class CasoDeUsoDeletarContato {
    private final ContatoRepository contatoRepository;

    public CasoDeUsoDeletarContato(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    public void execute(ContatoDto dto, Integer id) {
        Contato contato = new Contato();
        contato.setEmail1(dto.getEmail1());
        contato.setEmail2(dto.getEmail2());
        contato.setEmail3(dto.getEmail3());
        contato.setTelefone1(dto.getTelefone1());
        contato.setTelefone2(dto.getTelefone2());
        contato.setTelefone3(dto.getTelefone3());
        contato.setId(id);
        contatoRepository.remove(contato);
    }
}
