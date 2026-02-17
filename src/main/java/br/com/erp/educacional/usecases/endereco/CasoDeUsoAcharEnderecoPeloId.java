package br.com.erp.educacional.usecases.endereco;

import br.com.erp.educacional.adapter.dto.EnderecoDto;
import br.com.erp.educacional.domain.entity.commons.Endereco;
import br.com.erp.educacional.domain.repository.common.EnderecoRepository;

import java.util.Optional;

public class CasoDeUsoAcharEnderecoPeloId {
    private final EnderecoRepository enderecoRepository;

    public CasoDeUsoAcharEnderecoPeloId(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public Endereco execute(Integer id) {
        Optional<Endereco> enderecoOptional = enderecoRepository.findById(id);
        return enderecoOptional.orElseGet(Endereco::new);
    }
}
