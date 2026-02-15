package br.com.erp.educacional.adapter.controller;

import br.com.erp.educacional.adapter.dto.DocumentoDto;
import br.com.erp.educacional.usecases.documento.CasoDeUsoCriarDocumento;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentoController {
    private final CasoDeUsoCriarDocumento useCase;

    public DocumentoController(CasoDeUsoCriarDocumento useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/documento")
    public void criar(@RequestBody DocumentoDto dto) {
        useCase.execute(dto);
    }
}
