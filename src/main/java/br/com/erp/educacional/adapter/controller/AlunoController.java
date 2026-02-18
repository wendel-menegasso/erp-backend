package br.com.erp.educacional.adapter.controller;

import br.com.erp.educacional.adapter.dto.*;
import br.com.erp.educacional.domain.entity.commons.Documento;
import br.com.erp.educacional.domain.entity.commons.Endereco;
import br.com.erp.educacional.domain.entity.contato.Contato;
import br.com.erp.educacional.domain.entity.curso.Curso;
import br.com.erp.educacional.usecases.aluno.CasoDeUsoCriarAluno;
import br.com.erp.educacional.usecases.contato.CasoDeUsoAcharContatoPeloId;
import br.com.erp.educacional.usecases.contato.CasoDeUsoDeletarContato;
import br.com.erp.educacional.usecases.curso.CasoDeUsoAcharCursoPeloId;
import br.com.erp.educacional.usecases.curso.CasoDeUsoDeletarCurso;
import br.com.erp.educacional.usecases.documento.CasoDeUsoAcharDocumentoPeloId;
import br.com.erp.educacional.usecases.documento.CasoDeUsoDeletarDocumento;
import br.com.erp.educacional.usecases.endereco.CasoDeUsoAcharEnderecoPeloId;
import br.com.erp.educacional.usecases.endereco.CasoDeUsoDeletarEndereco;
import br.com.erp.educacional.usecases.turma.CasoDeUsoAcharTurmaPeloId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class AlunoController {

    @Autowired
    CasoDeUsoCriarAluno casoDeUsoCriarAluno;

    @Autowired
    CasoDeUsoAcharEnderecoPeloId casoDeUsoAcharEnderecoPeloId;

    @Autowired
    CasoDeUsoAcharTurmaPeloId casoDeUsoAcharTurmaPeloId;

    @Autowired
    CasoDeUsoAcharContatoPeloId casoDeUsoAcharContatoPeloId;

    @Autowired
    CasoDeUsoAcharDocumentoPeloId casoDeUsoAcharDocumentoPeloId;

    @Autowired
    CasoDeUsoAcharCursoPeloId casoDeUsoAcharCursoPeloId;

    @Autowired
    CasoDeUsoDeletarEndereco casoDeUsoDeletarEndereco;

    @Autowired
    CasoDeUsoDeletarCurso casoDeUsoDeletarCurso;

    @Autowired
    CasoDeUsoDeletarContato casoDeUsoDeletarContato;

    @Autowired
    CasoDeUsoDeletarDocumento casoDeUsoDeletarDocumento;

    @PostMapping("/aluno")
    @PreAuthorize("hasAuthority('/aluno')")
    public void criar(@RequestBody AlunoCompletoDto dto) {
        Endereco endereco = casoDeUsoAcharEnderecoPeloId.execute(dto.getEndereco());
        Contato contato = casoDeUsoAcharContatoPeloId.execute(dto.getContato());
        Documento documento = casoDeUsoAcharDocumentoPeloId.execute(dto.getDocumento());

//        DocumentoDto documentoDto = new DocumentoDto();
//        documentoDto.convert(documento);
//        casoDeUsoDeletarDocumento.execute(documentoDto, documento.getId());
//
//        ContatoDto contatoDto = new ContatoDto();
//        contatoDto.convert(contato);
//        casoDeUsoDeletarContato.execute(contatoDto, contato.getId());
//
//        EnderecoDto enderecoDto = new EnderecoDto();
//        enderecoDto.convert(endereco);
//        casoDeUsoDeletarEndereco.execute(enderecoDto, endereco.getId());

        AlunoDto dtoAluno = dto.getAluno();
        dtoAluno.setEndereco(endereco);
        dtoAluno.setContato(contato);
        dtoAluno.setCurso(dto.getCurso());
        dtoAluno.setDocumentos(documento);

        casoDeUsoCriarAluno.execute(dtoAluno);
    }
}
