package br.com.erp.educacional.adapter.controller;

import br.com.erp.educacional.adapter.dto.CursoDto;
import br.com.erp.educacional.domain.entity.curso.Curso;
import br.com.erp.educacional.usecases.curso.CasoDeUsoCriarCurso;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class CursoController {
    private final CasoDeUsoCriarCurso useCase;

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
}
