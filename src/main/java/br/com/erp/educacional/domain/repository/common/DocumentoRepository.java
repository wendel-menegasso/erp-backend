package br.com.erp.educacional.domain.repository.common;

import br.com.erp.educacional.domain.entity.commons.Documento;
import br.com.erp.educacional.domain.entity.contato.Contato;

public interface DocumentoRepository {
    void save(Documento documento);
}
