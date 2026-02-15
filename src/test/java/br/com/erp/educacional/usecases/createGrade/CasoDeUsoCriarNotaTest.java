package br.com.erp.educacional.usecases.createGrade;

import br.com.erp.educacional.domain.entity.aluno.Aluno;
import br.com.erp.educacional.domain.entity.commons.Periodo;
import br.com.erp.educacional.domain.entity.curso.Curso;
import br.com.erp.educacional.domain.entity.disciplina.Disciplina;
import br.com.erp.educacional.domain.entity.professor.Professor;
import br.com.erp.educacional.infrastructure.database.repository.NotaRepositoryJPA;
import br.com.erp.educacional.usecases.nota.CasoDeUsoCriarNota;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CasoDeUsoCriarNotaTest {

    @Test
    public void testExecute() {
        NotaRepositoryJPA notaRepository = Mockito.mock(NotaRepositoryJPA.class);
        CasoDeUsoCriarNota casoDeUsoCriarNota = new CasoDeUsoCriarNota(notaRepository);

        Curso curso1 = new Curso();
        curso1.setPeriodo(Periodo.NOITE);
        curso1.setId(1);
        curso1.setNome("Ciências da Computação");

        Aluno aluno1 = new Aluno();
        aluno1.setNome("Wendel");
        aluno1.setBolsista(true);
        aluno1.setCurso(curso1);

        Disciplina disciplina = new Disciplina();
        disciplina.setId(1);
        disciplina.setNome("Calculo");

        List<Curso> cursoList = new ArrayList<>();
        Curso curso = new Curso();
        curso.setId(1);
        curso.setNome("Ciências da Computação");
        curso.setPeriodo(Periodo.NOITE);
        cursoList.add(curso);

        Professor professor1 = new Professor();
        casoDeUsoCriarNota.execute(1, aluno1, disciplina, professor1, 10, 100);
        verify(notaRepository, times(1)).save(any());
    }
}