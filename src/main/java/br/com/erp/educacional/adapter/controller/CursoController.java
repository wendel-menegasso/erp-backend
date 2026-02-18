package br.com.erp.educacional.adapter.controller;

import br.com.erp.educacional.adapter.dto.CursoDto;
import br.com.erp.educacional.domain.entity.curso.Curso;
import br.com.erp.educacional.usecases.curso.CasoDeUsoCriarCurso;
import br.com.erp.educacional.usecases.curso.CasoDeUsoRetornarTudo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class CursoController {
    private final CasoDeUsoCriarCurso useCase;

    @Autowired
    private CasoDeUsoRetornarTudo casoDeUsoRetornarTudo;

    public CursoController(CasoDeUsoCriarCurso useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/curso")
    @PreAuthorize("hasAuthority('/curso')")
    public void criar(@RequestBody CursoDto dto) {
        Curso curso = new Curso();
        curso.setNome(dto.getNome());
        curso.setPeriodo(dto.getPeriodo());
        useCase.execute(curso);
    }

    @GetMapping("/curso")
    @PreAuthorize("hasAuthority('/curso')")
    public ResponseEntity<?> procurarTudo() {
        return ResponseEntity.ok(casoDeUsoRetornarTudo.execute());
    }
}
