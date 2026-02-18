package br.com.erp.educacional.domain.repository.common;

import br.com.erp.educacional.domain.entity.commons.Documento;
import br.com.erp.educacional.domain.entity.contato.Contato;

import java.util.Optional;

public interface DocumentoRepository {
    void save(Documento documento);
    Optional<Documento> findById(int id);
    void remove(Documento documento);
    int count();
}
