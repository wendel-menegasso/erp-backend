package br.com.erp.educacional.adapter.controller;

import br.com.erp.educacional.adapter.dto.ContatoDto;
import br.com.erp.educacional.adapter.dto.CursoDto;
import br.com.erp.educacional.domain.entity.contato.Contato;
import br.com.erp.educacional.domain.entity.curso.Curso;
import br.com.erp.educacional.usecases.curso.CasoDeUsoCriarCurso;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CursoController {
    private final CasoDeUsoCriarCurso useCase;

    public CursoController(CasoDeUsoCriarCurso useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/curso")
    public void criar(@RequestBody CursoDto dto) {
        Curso curso = new Curso();
        curso.setNome(dto.getNome());
        curso.setPeriodo(dto.getPeriodo());
        useCase.execute(curso);
    }
}
