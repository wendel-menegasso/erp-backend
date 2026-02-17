package br.com.erp.educacional.infrastructure.config;

import br.com.erp.educacional.domain.repository.aluno.AlunoRepository;
import br.com.erp.educacional.domain.repository.common.DocumentoRepository;
import br.com.erp.educacional.domain.repository.common.EnderecoRepository;
import br.com.erp.educacional.domain.repository.contato.ContatoRepository;
import br.com.erp.educacional.domain.repository.curso.CursoRepository;
import br.com.erp.educacional.domain.repository.disciplina.DisciplinaRepository;
import br.com.erp.educacional.domain.repository.nota.NotaRepository;
import br.com.erp.educacional.domain.repository.turma.TurmaRepository;
import br.com.erp.educacional.infrastructure.database.repository.*;
import br.com.erp.educacional.usecases.aluno.CasoDeUsoCriarAluno;
import br.com.erp.educacional.usecases.contato.CasoDeUsoAcharContatoPeloId;
import br.com.erp.educacional.usecases.contato.CasoDeUsoCriarContato;
import br.com.erp.educacional.usecases.curso.CasoDeUsoAcharCursoPeloId;
import br.com.erp.educacional.usecases.curso.CasoDeUsoCriarCurso;
import br.com.erp.educacional.usecases.disciplina.CasoDeUsoCriarDisciplina;
import br.com.erp.educacional.usecases.disciplina.CasoDeUsoVerificarSeDisciplinaExiste;
import br.com.erp.educacional.usecases.documento.CasoDeUsoAcharDocumentoPeloId;
import br.com.erp.educacional.usecases.documento.CasoDeUsoCriarDocumento;
import br.com.erp.educacional.usecases.endereco.CasoDeUsoAcharEnderecoPeloId;
import br.com.erp.educacional.usecases.endereco.CasoDeUsoCriarEndereco;
import br.com.erp.educacional.usecases.nota.CasoDeUsoCriarNota;
import br.com.erp.educacional.usecases.turma.CasoDeUsoAcharTurmaPeloId;
import br.com.erp.educacional.usecases.turma.CasoDeUsoCriarTurma;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public ContatoRepository contatoRepository() { return  new ContatoRepositoryJPA(); }

    @Bean
    public NotaRepository notaRepository() {
        return new NotaRepositoryJPA();
    }

    @Bean
    public EnderecoRepository enderecoRepository() {
        return new EnderecoRepositoryJPA();
    }

    @Bean
    public DisciplinaRepository disciplinaRepository() {return new DisciplinaRepoCustom();}

    @Bean
    public DocumentoRepository documentoRepository() {return new DocumentoRepositoryJPA();}

    @Bean
    public TurmaRepository turmaRepository() {return  new TurmaRepositoryJPA();}

    @Bean
    public CursoRepository cursoRepository() {return  new CursoRepositoryJPA();}

    @Bean
    public AlunoRepository alunoRepository() {return new AlunoRepositoryJPA();}

    @Bean
    public CasoDeUsoCriarContato casoDeUsoCriarContato(ContatoRepository repo) {
        return new CasoDeUsoCriarContato(repo);
    }

    @Bean
    public CasoDeUsoCriarNota casoDeUsoCriarNota(NotaRepository repo) {
        return new CasoDeUsoCriarNota(repo);
    }

    @Bean
    public CasoDeUsoCriarDisciplina casoDeUsoCriarDisciplina(DisciplinaRepository repo) {
        return new CasoDeUsoCriarDisciplina(repo);
    }

    @Bean
    public CasoDeUsoVerificarSeDisciplinaExiste casoDeUsoVerificarSeDisciplinaExiste(DisciplinaRepository repo) {
        return new CasoDeUsoVerificarSeDisciplinaExiste(repo);
    }

    @Bean
    public CasoDeUsoCriarEndereco casoDeUsoCriarEndereco(EnderecoRepository repo) {
        return new CasoDeUsoCriarEndereco(repo);
    }

    @Bean
    public CasoDeUsoCriarDocumento casoDeUsoCriarDocumento(DocumentoRepository repo) {
        return new CasoDeUsoCriarDocumento(repo);
    }

    @Bean
    public CasoDeUsoCriarTurma casoDeUsoCriarTurma(TurmaRepository repo) {
        return new CasoDeUsoCriarTurma(repo);
    }

    @Bean
    public CasoDeUsoCriarCurso casoDeUsoCriarCurso(CursoRepository repo) {
        return new CasoDeUsoCriarCurso(repo);
    }

    @Bean
    public CasoDeUsoCriarAluno casoDeUsoCriarAluno(AlunoRepository repo) {
        return new CasoDeUsoCriarAluno(repo);
    }

    @Bean
    public CasoDeUsoAcharDocumentoPeloId casoDeUsoAcharDocumentoPeloId(DocumentoRepository repo) {
        return new CasoDeUsoAcharDocumentoPeloId(repo);
    }
    @Bean
    public CasoDeUsoAcharEnderecoPeloId casoDeUsoAcharEnderecoPeloId(EnderecoRepository repo) {
        return new CasoDeUsoAcharEnderecoPeloId(repo);
    }

    @Bean
    public CasoDeUsoAcharContatoPeloId casoDeUsoAcharContatoPeloId(ContatoRepository repo) {
        return new CasoDeUsoAcharContatoPeloId(repo);
    }
    @Bean
    public CasoDeUsoAcharTurmaPeloId casoDeUsoAcharTurmaPeloId(TurmaRepository repo) {
        return new CasoDeUsoAcharTurmaPeloId(repo);
    }

    @Bean
    public CasoDeUsoAcharCursoPeloId casoDeUsoAcharCursoPeloId(CursoRepository repo) {
        return new CasoDeUsoAcharCursoPeloId(repo);
    }
}
