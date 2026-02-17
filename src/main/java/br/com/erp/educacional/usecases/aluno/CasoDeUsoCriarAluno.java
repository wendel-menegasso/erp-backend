package br.com.erp.educacional.usecases.aluno;

import br.com.erp.educacional.adapter.dto.AlunoDto;
import br.com.erp.educacional.domain.entity.aluno.Aluno;
import br.com.erp.educacional.domain.entity.commons.Documento;
import br.com.erp.educacional.domain.entity.commons.Endereco;
import br.com.erp.educacional.domain.entity.contato.Contato;
import br.com.erp.educacional.domain.repository.aluno.AlunoRepository;
import br.com.erp.educacional.infrastructure.database.model.AlunoModel;
import br.com.erp.educacional.infrastructure.database.model.EnderecoModel;
import br.com.erp.educacional.usecases.contato.CasoDeUsoAcharContatoPeloId;
import br.com.erp.educacional.usecases.curso.CasoDeUsoAcharCursoPeloId;
import br.com.erp.educacional.usecases.documento.CasoDeUsoAcharDocumentoPeloId;
import br.com.erp.educacional.usecases.endereco.CasoDeUsoAcharEnderecoPeloId;
import br.com.erp.educacional.usecases.turma.CasoDeUsoAcharTurmaPeloId;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CasoDeUsoCriarAluno {
    private final AlunoRepository repository;

    @Autowired
    private CasoDeUsoAcharDocumentoPeloId casoDeUsoAcharDocumentoPeloId;

    @Autowired
    private CasoDeUsoAcharEnderecoPeloId casoDeUsoAcharEnderecoPeloId;

    @Autowired
    private CasoDeUsoAcharContatoPeloId casoDeUsoAcharContatoPeloId;

    @Autowired
    private CasoDeUsoAcharTurmaPeloId casoDeUsoAcharTurmaPeloId;

    @Autowired
    private CasoDeUsoAcharCursoPeloId casoDeUsoAcharCursoPeloId;

    public CasoDeUsoCriarAluno(AlunoRepository repository) {
        this.repository = repository;
    }

    public void execute(AlunoDto dto) {
        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setBolsista(dto.getBolsista());
        aluno.setContato(casoDeUsoAcharContatoPeloId.execute(dto.getContato().getId()));
        aluno.setMae(dto.getMae());
        aluno.setCurso(casoDeUsoAcharCursoPeloId.execute(dto.getCurso().getId()));
        aluno.setDocumentos(casoDeUsoAcharDocumentoPeloId.execute(dto.getDocumentos().getId()));
        aluno.setEndereco(casoDeUsoAcharEnderecoPeloId.execute(dto.getEndereco().getId()));
        aluno.setPai(dto.getPai());
        aluno.setTurma(casoDeUsoAcharTurmaPeloId.execute(dto.getTurma().getId()));
        aluno.setValorBolsa(dto.getValorBolsa());
        aluno.setNumeroDeMatricula(dto.getNumeroDeMatricula());
        repository.save(aluno);
    }
}
