package br.com.erp.educacional.usecases.documento;

import br.com.erp.educacional.adapter.dto.DocumentoDto;
import br.com.erp.educacional.domain.entity.commons.Documento;
import br.com.erp.educacional.domain.repository.common.DocumentoRepository;

public class CasoDeUsoDeletarDocumento {
    private final DocumentoRepository repository;

    public CasoDeUsoDeletarDocumento(DocumentoRepository repository) {
        this.repository = repository;
    }

    public void execute(DocumentoDto documentoDto, Integer id) {
        Documento documento = new Documento();
        documento.setRG(documentoDto.getRg());
        documento.setCPF(documentoDto.getCpf());
        documento.setTituloDeEleitor(documentoDto.getTituloDeEleitor());
        documento.setCarteiraDeTralho(documentoDto.getCarteiraDeTralho());
        documento.setCREA(documentoDto.getCrea());
        documento.setReservista(documentoDto.getReservista());
        documento.setOAB(documentoDto.getOab());
        documento.setId(id);
        repository.remove(documento);
    }
}
