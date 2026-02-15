package br.com.erp.educacional.usecases.documento;

import br.com.erp.educacional.adapter.dto.DocumentoDto;
import br.com.erp.educacional.adapter.dto.EnderecoDto;
import br.com.erp.educacional.domain.entity.commons.Documento;
import br.com.erp.educacional.domain.entity.commons.Endereco;
import br.com.erp.educacional.domain.repository.common.DocumentoRepository;
import br.com.erp.educacional.domain.repository.common.EnderecoRepository;

public class CasoDeUsoCriarDocumento {
    private final DocumentoRepository repository;

    public CasoDeUsoCriarDocumento(DocumentoRepository repository) {
        this.repository = repository;
    }

    public void execute(DocumentoDto documentoDto) {
        Documento documento = new Documento();
        documento.setRG(documentoDto.getRG());
        documento.setCPF(documentoDto.getCPF());
        documento.setTituloDeEleitor(documentoDto.getTituloDeEleitor());
        documento.setCarteiraDeTralho(documentoDto.getCarteiraDeTralho());
        documento.setCREA(documentoDto.getCREA());
        documento.setReservista(documentoDto.getReservista());
        documento.setOAB(documentoDto.getOAB());
        repository.save(documento);
    }

}
