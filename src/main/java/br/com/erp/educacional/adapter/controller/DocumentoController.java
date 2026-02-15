package br.com.erp.educacional.adapter.controller;

import br.com.erp.educacional.adapter.dto.DocumentoDto;
import br.com.erp.educacional.usecases.documento.CasoDeUsoCriarDocumento;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class DocumentoController {
    private final CasoDeUsoCriarDocumento useCase;

    public DocumentoController(CasoDeUsoCriarDocumento useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/documento")
    public void criar(@RequestBody DocumentoDto dto) {
        DocumentoDto documento = new DocumentoDto();
        documento.setRG(dto.getRG());
        documento.setCREA(dto.getCREA());
        documento.setOAB(dto.getOAB());
        documento.setCPF(dto.getCPF());
        documento.setReservista(dto.getReservista());
        documento.setCarteiraDeTralho(dto.getCarteiraDeTralho());
        documento.setTituloDeEleitor(dto.getTituloDeEleitor());
        useCase.execute(documento);
    }
}
