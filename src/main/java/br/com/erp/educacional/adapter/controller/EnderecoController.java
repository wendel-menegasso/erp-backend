package br.com.erp.educacional.adapter.controller;

import br.com.erp.educacional.adapter.dto.EnderecoDto;
import br.com.erp.educacional.usecases.endereco.CasoDeUsoCriarEndereco;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class EnderecoController {
    private final CasoDeUsoCriarEndereco useCase;

    public EnderecoController(CasoDeUsoCriarEndereco useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/endereco")
    @PreAuthorize("hasAuthority('/endereco')")
    public ResponseEntity<Integer> criar(@RequestBody EnderecoDto dto) {
        return ResponseEntity.ok(useCase.execute(dto));
    }
}
