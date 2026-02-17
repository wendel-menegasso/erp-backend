package br.com.erp.educacional.adapter.controller;

import br.com.erp.educacional.adapter.dto.DisciplinaDTO;
import br.com.erp.educacional.usecases.disciplina.CasoDeUsoCriarDisciplina;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class DisciplinaController {
    private final CasoDeUsoCriarDisciplina useCase;

    public DisciplinaController(CasoDeUsoCriarDisciplina useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/disciplina")
    @PreAuthorize("hasAuthority('/disciplina')")
    public void criar(@RequestBody DisciplinaDTO dto) {
        useCase.execute(dto.nomeDisciplina);
    }
}
