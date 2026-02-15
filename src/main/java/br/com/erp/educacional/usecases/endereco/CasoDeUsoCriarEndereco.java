package br.com.erp.educacional.usecases.endereco;

import br.com.erp.educacional.adapter.dto.EnderecoDto;
import br.com.erp.educacional.domain.entity.commons.Endereco;
import br.com.erp.educacional.domain.repository.common.EnderecoRepository;

public class CasoDeUsoCriarEndereco {
    private final EnderecoRepository enderecoRepository;

    public CasoDeUsoCriarEndereco(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public void execute(EnderecoDto enderecoDto) {
        Endereco endereco = new Endereco();
        endereco.setBairro(enderecoDto.getBairro());
        endereco.setCep(enderecoDto.getCep());
        endereco.setNumero(enderecoDto.getNumero());
        endereco.setPais(enderecoDto.getPais());
        endereco.setEstado(enderecoDto.getEstado());
        endereco.setCidade(enderecoDto.getCidade());
        endereco.setRua(enderecoDto.getRua());
        enderecoRepository.save(endereco);
    }
}
