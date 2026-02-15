package br.com.erp.educacional.adapter.controller;

import br.com.erp.educacional.adapter.dto.TurmaDto;
import br.com.erp.educacional.usecases.turma.CasoDeUsoCriarTurma;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TurmaController {
    private final CasoDeUsoCriarTurma useCase;

    public TurmaController(CasoDeUsoCriarTurma useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/turma")
    public void criar(@RequestBody TurmaDto dto) {
        useCase.execute(dto);
    }
}
