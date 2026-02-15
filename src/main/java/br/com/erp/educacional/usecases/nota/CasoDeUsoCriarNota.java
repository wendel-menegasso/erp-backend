package br.com.erp.educacional.usecases.nota;

import br.com.erp.educacional.domain.entity.aluno.Aluno;
import br.com.erp.educacional.domain.entity.disciplina.Disciplina;
import br.com.erp.educacional.domain.entity.nota.Nota;
import br.com.erp.educacional.domain.entity.professor.Professor;
import br.com.erp.educacional.domain.repository.nota.NotaRepository;

public class CasoDeUsoCriarNota {
    private final NotaRepository gradeRepo;

    public CasoDeUsoCriarNota(NotaRepository gradeRepo) {
        this.gradeRepo = gradeRepo;
    }

    public void execute(int id, Aluno aluno, Disciplina disciplina, Professor professor, int peso, double nota) {
        Nota nota1 = new Nota();
        nota1.registrarNota(id, aluno, disciplina, professor, peso, nota);
        gradeRepo.save(nota1);
    }
}
