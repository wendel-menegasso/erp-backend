package br.com.erp.educacional.adapter.controller;

import br.com.erp.educacional.adapter.dto.DocumentoDto;
import br.com.erp.educacional.usecases.documento.CasoDeUsoCriarDocumento;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class DocumentoController {
    private final CasoDeUsoCriarDocumento useCase;

    public DocumentoController(CasoDeUsoCriarDocumento useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/documento")
    @PreAuthorize("hasAuthority('documento')")
    public void criar(@RequestBody DocumentoDto dto) {
        useCase.execute(dto);
    }
}
