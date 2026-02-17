package br.com.erp.educacional.adapter.controller;

import br.com.erp.educacional.adapter.dto.AlunoDto;
import br.com.erp.educacional.usecases.aluno.CasoDeUsoCriarAluno;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class AlunoController {
    private final CasoDeUsoCriarAluno useCase;


    public AlunoController(CasoDeUsoCriarAluno useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/aluno")
    @PreAuthorize("hasAuthority('/aluno')")
    public void criar(@RequestBody AlunoDto dto) {
        useCase.execute(dto);
    }
}
