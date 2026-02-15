package br.com.erp.educacional.infrastructure.config;

import br.com.erp.educacional.domain.repository.common.DocumentoRepository;
import br.com.erp.educacional.domain.repository.common.EnderecoRepository;
import br.com.erp.educacional.domain.repository.contato.ContatoRepository;
import br.com.erp.educacional.domain.repository.disciplina.DisciplinaRepository;
import br.com.erp.educacional.domain.repository.nota.NotaRepository;
import br.com.erp.educacional.infrastructure.database.repository.*;
import br.com.erp.educacional.usecases.contato.CasoDeUsoCriarContato;
import br.com.erp.educacional.usecases.disciplina.CasoDeUsoCriarDisciplina;
import br.com.erp.educacional.usecases.disciplina.CasoDeUsoVerificarSeDisciplinaExiste;
import br.com.erp.educacional.usecases.documento.CasoDeUsoCriarDocumento;
import br.com.erp.educacional.usecases.endereco.CasoDeUsoCriarEndereco;
import br.com.erp.educacional.usecases.nota.CasoDeUsoCriarNota;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public ContatoRepository contatoRepository() { return  new ContatoRepositoryJPA(); }

    @Bean
    public CasoDeUsoCriarContato casoDeUsoCriarContato(ContatoRepository repo) {
        return new CasoDeUsoCriarContato(repo);
    }

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
}
