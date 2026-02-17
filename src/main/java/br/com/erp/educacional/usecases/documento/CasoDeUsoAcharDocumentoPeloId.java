package br.com.erp.educacional.usecases.documento;

import br.com.erp.educacional.adapter.dto.DocumentoDto;
import br.com.erp.educacional.domain.entity.commons.Documento;
import br.com.erp.educacional.domain.repository.common.DocumentoRepository;

import java.util.Optional;

public class CasoDeUsoAcharDocumentoPeloId {
    private final DocumentoRepository repository;

    public CasoDeUsoAcharDocumentoPeloId(DocumentoRepository repository) {
        this.repository = repository;
    }

    public Documento execute(Integer id) {
        return repository.findById(id).orElseGet(Documento::new);
    }
}
