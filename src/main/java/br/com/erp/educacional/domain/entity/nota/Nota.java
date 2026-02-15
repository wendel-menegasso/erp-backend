package br.com.erp.educacional.domain.entity.nota;

import br.com.erp.educacional.domain.entity.aluno.Aluno;
import br.com.erp.educacional.domain.entity.disciplina.Disciplina;
import br.com.erp.educacional.domain.entity.professor.Professor;
import lombok.Getter;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Nota{

    private int id;
    private Aluno aluno;
    private Disciplina disciplina;
    private Professor professor;
    private int peso;
    private double nota;
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Nota.class);
    private List<Nota> notas = new ArrayList<>();
    private double notaFinal;

    public void registrarNota(int id, Aluno aluno, Disciplina disciplina, Professor professor, int peso, double nota) {
        this.id = id;
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.professor = professor;
        if (peso < 1 || peso > 10) {
            throw new RuntimeException("Invalid weight");
        }
        if (nota < 0 || nota > 100) {
            throw new RuntimeException("Invalid grade");
        }
        this.peso = peso;
        this.nota = nota * ((double) peso / 10);
        logger.info("Nota criada com sucesso {}", this);
        notas.add(this);
    }

    public boolean isApproved() {
        return this.notaFinal >= 70.0;
    }

    public boolean isExam() {
        return this.notaFinal >= 50.0 && this.notaFinal < 70.0;
    }

    public boolean isReproved() {
        return this.notaFinal < 50.0;
    }

    public void calculateFinalNote() {
        double some = 0;
        for (Nota note : notas) {
            some = some + note.getNota();
        }
        this.notaFinal = some / notas.size();
    }

    @Override
    public String toString() {
        return "Nota{" +
                "id=" + id +
                ", aluno=" + aluno +
                ", disciplina=" + disciplina +
                ", professor=" + professor +
                ", peso=" + peso +
                ", nota=" + nota +
                '}';
    }
}
