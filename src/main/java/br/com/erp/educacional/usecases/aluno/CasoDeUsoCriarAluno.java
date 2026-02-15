package br.com.erp.educacional.usecases.aluno;

import br.com.erp.educacional.adapter.dto.AlunoDto;
import br.com.erp.educacional.domain.entity.aluno.Aluno;
import br.com.erp.educacional.domain.repository.aluno.AlunoRepository;

public class CasoDeUsoCriarAluno {
    private final AlunoRepository repository;

    public CasoDeUsoCriarAluno(AlunoRepository repository) {
        this.repository = repository;
    }

    public void execute(AlunoDto dto) {
        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setBolsista(dto.isBolsista());
        aluno.setContato(dto.getContato());
        aluno.setMae(dto.getMae());
        aluno.setCurso(dto.getCurso());
        aluno.setDocumentos(dto.getDocumentos());
        aluno.setEndereco(dto.getEndereco());
        aluno.setPai(dto.getPai());
        aluno.setTurma(dto.getTurma());
        aluno.setValorBolsa(dto.getValorBolsa());
        aluno.setNumeroDeMatricula(dto.getNumeroDeMatricula());
        repository.save(aluno);
    }
}
