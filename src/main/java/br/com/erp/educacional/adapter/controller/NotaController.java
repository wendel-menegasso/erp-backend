package br.com.erp.educacional.adapter.controller;

import br.com.erp.educacional.adapter.dto.NotaDTO;
import br.com.erp.educacional.usecases.nota.CasoDeUsoCriarNota;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class NotaController {

    private final CasoDeUsoCriarNota useCase;

    public NotaController(CasoDeUsoCriarNota useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/notas")
    @PreAuthorize("hasAuthority('/nota')")
    public void criar(@RequestBody NotaDTO dto) {
        useCase.execute(dto.aluno, dto.disciplina, dto.professor, dto.peso, dto.nota);
    }
}

