package br.com.erp.educacional.domain.entity.nota;

import br.com.erp.educacional.domain.entity.aluno.Aluno;
import br.com.erp.educacional.domain.entity.disciplina.Disciplina;
import br.com.erp.educacional.domain.entity.professor.Professor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NotaTest {
    @Test
    public void verifyNotaValida() {
        Nota nota = new Nota();
        assertThrows(RuntimeException.class, () -> nota.registrarNota(1, new Aluno(), new Disciplina(), new Professor(), 0, -1));
        assertThrows(RuntimeException.class, () -> nota.registrarNota(1, new Aluno(), new Disciplina(), new Professor(), 1, -1));
        assertThrows(RuntimeException.class, () -> nota.registrarNota(1, new Aluno(), new Disciplina(), new Professor(), 0, 1));
        assertThrows(RuntimeException.class, () -> nota.registrarNota(1, new Aluno(), new Disciplina(), new Professor(), 11, 101));
        assertThrows(RuntimeException.class, () -> nota.registrarNota(1, new Aluno(), new Disciplina(), new Professor(), 11, 101));
        assertThrows(RuntimeException.class, () -> nota.registrarNota(1, new Aluno(), new Disciplina(), new Professor(), 1, 101));
        assertThrows(RuntimeException.class, () -> nota.registrarNota(1, new Aluno(), new Disciplina(), new Professor(), 11, 1));
        assertThrows(RuntimeException.class, () -> nota.registrarNota(1, new Aluno(), new Disciplina(), new Professor(), 0, 101));
        assertThrows(RuntimeException.class, () -> nota.registrarNota(1, new Aluno(), new Disciplina(), new Professor(), 11, -1));
        assertThrows(RuntimeException.class, () -> nota.registrarNota(1, new Aluno(), new Disciplina(), new Professor(), 0, -1));
        assertThrows(RuntimeException.class, () -> nota.registrarNota(1, new Aluno(), new Disciplina(), new Professor(), 0, -1));
        nota.registrarNota(1, new Aluno(), new Disciplina(), new Professor(), 7, 100);
        assertEquals(70, nota.getNota());
        nota.registrarNota(1, new Aluno(), new Disciplina(), new Professor(), 7, 70);
        assertEquals(49, nota.getNota());
    }

    @Test
    public void verifyStatusNoteWithASingleNote() {
        Nota nota = new Nota();
        nota.registrarNota(1, new Aluno(), new Disciplina(), new Professor(), 7, 100);
        nota.calculateFinalNote();
        Assertions.assertTrue(nota.isApproved());

        Nota nota1 = new Nota();
        nota1.registrarNota(1, new Aluno(), new Disciplina(), new Professor(), 10, 50);
        nota1.calculateFinalNote();
        Assertions.assertTrue(nota1.isExam());

        Nota nota2 = new Nota();
        nota2.registrarNota(1, new Aluno(), new Disciplina(), new Professor(), 10, 51);
        nota2.calculateFinalNote();
        Assertions.assertTrue(nota2.isExam());

        Nota nota3 = new Nota();
        nota3.registrarNota(1, new Aluno(), new Disciplina(), new Professor(), 10, 71);
        nota3.calculateFinalNote();
        Assertions.assertTrue(nota3.isApproved());

        Nota nota4 = new Nota();
        nota4.registrarNota(1, new Aluno(), new Disciplina(), new Professor(), 10, 69);
        nota4.calculateFinalNote();
        Assertions.assertTrue(nota4.isExam());

        Nota nota5 = new Nota();
        nota5.registrarNota(1, new Aluno(), new Disciplina(), new Professor(), 10, 49);
        nota5.calculateFinalNote();
        Assertions.assertTrue(nota5.isReproved());
    }

    @Test
    public void verifyStatusNoteMultipleNotes() {
        Nota nota = new Nota();
        nota.registrarNota(1, new Aluno(), new Disciplina(), new Professor(), 7, 100);
        nota.registrarNota(1, new Aluno(), new Disciplina(), new Professor(), 7, 0);
        nota.calculateFinalNote();
        Assertions.assertTrue(nota.isReproved());
        nota.registrarNota(1, new Aluno(), new Disciplina(), new Professor(), 10, 90);
        nota.calculateFinalNote();
        Assertions.assertTrue(nota.isApproved());
        nota.registrarNota(1, new Aluno(), new Disciplina(), new Professor(), 10, 50);
        nota.calculateFinalNote();
        Assertions.assertTrue(nota.isExam());
    }
}