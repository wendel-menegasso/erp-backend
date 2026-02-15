package br.com.erp.educacional.adapter.controller;

import br.com.erp.educacional.adapter.dto.ContatoDto;
import br.com.erp.educacional.domain.entity.contato.Contato;
import br.com.erp.educacional.usecases.contato.CasoDeUsoCriarContato;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContatoController {
    private final CasoDeUsoCriarContato useCase;

    public ContatoController(CasoDeUsoCriarContato useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/contato")
    public void criar(@RequestBody ContatoDto dto) {
        Contato contato = new Contato();
        contato.setEmail1(dto.getEmail1());
        contato.setEmail2(dto.getEmail2());
        contato.setEmail3(dto.getEmail3());
        contato.setTelefone1(dto.getTelefone1());
        contato.setTelefone2(dto.getTelefone2());
        contato.setTelefone3(dto.getTelefone3());
        useCase.execute(contato);
    }
}
