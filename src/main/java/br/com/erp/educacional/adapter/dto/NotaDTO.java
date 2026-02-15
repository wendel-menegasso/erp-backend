package br.com.erp.educacional.adapter.dto;

import br.com.erp.educacional.domain.entity.aluno.Aluno;
import br.com.erp.educacional.domain.entity.disciplina.Disciplina;
import br.com.erp.educacional.domain.entity.professor.Professor;

public class NotaDTO {
    public int id;
    public Aluno aluno;
    public Disciplina disciplina;
    public Professor professor;
    public int peso;
    public double nota;
}
