package br.com.erp.educacional.adapter.controller;

import br.com.erp.educacional.adapter.dto.AlunoDto;
import br.com.erp.educacional.adapter.dto.ContatoDto;
import br.com.erp.educacional.domain.entity.contato.Contato;
import br.com.erp.educacional.usecases.aluno.CasoDeUsoCriarAluno;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlunoController {
    private final CasoDeUsoCriarAluno useCase;


    public AlunoController(CasoDeUsoCriarAluno useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/aluno")
    public void criar(@RequestBody AlunoDto dto) {
        useCase.execute(dto);
    }
}
