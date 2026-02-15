package br.com.erp.educacional.adapter.controller;

import br.com.erp.educacional.adapter.dto.EnderecoDto;
import br.com.erp.educacional.usecases.endereco.CasoDeUsoCriarEndereco;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnderecoController {
    private final CasoDeUsoCriarEndereco useCase;

    public EnderecoController(CasoDeUsoCriarEndereco useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/endereco")
    public void criar(@RequestBody EnderecoDto dto) {
        useCase.execute(dto);
    }
}
