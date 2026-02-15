package br.com.erp.educacional.adapter.controller;

import br.com.erp.educacional.adapter.dto.NotaDTO;
import br.com.erp.educacional.domain.entity.aluno.Aluno;
import br.com.erp.educacional.domain.entity.disciplina.Disciplina;
import br.com.erp.educacional.domain.entity.professor.Professor;
import br.com.erp.educacional.usecases.nota.CasoDeUsoCriarNota;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class NotaControllerTest {
    @Test
    public void criarTest() {
        CasoDeUsoCriarNota useCase = Mockito.mock(CasoDeUsoCriarNota.class);

        NotaDTO notaDTO = new NotaDTO();
        notaDTO.id = 1;
        notaDTO.nota = 100;
        notaDTO.peso = 10;
        notaDTO.disciplina = new Disciplina();
        notaDTO.professor = new Professor();
        notaDTO.aluno = new Aluno();

        NotaController notaController = new NotaController(useCase);
        notaController.criar(notaDTO);
        verify(useCase, times(1)).execute(notaDTO.id, notaDTO.aluno,
                notaDTO.disciplina, notaDTO.professor, notaDTO.peso, notaDTO.nota);
    }
}