package br.com.erp.educacional.infrastructure.database.repository;

import br.com.erp.educacional.domain.entity.aluno.Aluno;
import br.com.erp.educacional.domain.entity.commons.Endereco;
import br.com.erp.educacional.domain.repository.aluno.AlunoRepository;
import br.com.erp.educacional.infrastructure.database.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

public class AlunoRepositoryJPA implements AlunoRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void save(Aluno aluno) {
        AlunoModel alunoModel = new AlunoModel();
        alunoModel.setNome(aluno.getNome());
        alunoModel.setBolsista(aluno.isBolsista());

        ContatoModel contatoModel = getContatoModel(aluno);
        alunoModel.setContatos(contatoModel);

        alunoModel.setMae(aluno.getMae());
        CursoModel cursoModel = new CursoModel();
        cursoModel.setId(aluno.getCurso().getId());
        cursoModel.setNome(aluno.getCurso().getNome());
        cursoModel.setPeriodo(aluno.getCurso().getPeriodo());
        alunoModel.setCurso(cursoModel);

        DocumentoModel documentoModel = getDocumentoModel(aluno);
        alunoModel.setDocumentos(documentoModel);
        alunoModel.setEnderecos(getEnderecoModel(aluno.getEndereco(), alunoModel));
        alunoModel.setPai(aluno.getPai());
        
        TurmaModel turmaModel = new TurmaModel();
        turmaModel.setId(aluno.getTurma().getId());
        turmaModel.setNome(aluno.getTurma().getNome());
        turmaModel.setPeriodo(aluno.getTurma().getPeriodo());
        alunoModel.setTurma(turmaModel);
        alunoModel.setValorBolsa(aluno.getValorBolsa());
        alunoModel.setNumeroDeMatricula(aluno.getNumeroDeMatricula());
        em.persist(alunoModel);
    }

    private static ContatoModel getContatoModel(Aluno aluno) {
        ContatoModel contatoModel = new ContatoModel();
        contatoModel.setId(aluno.getContato().getId());
        contatoModel.setEmail1(aluno.getContato().getEmail1());
        contatoModel.setEmail2(aluno.getContato().getEmail2());
        contatoModel.setEmail3(aluno.getContato().getEmail3());
        contatoModel.setTelefone1(aluno.getContato().getTelefone1());
        contatoModel.setTelefone2(aluno.getContato().getTelefone2());
        contatoModel.setTelefone3(aluno.getContato().getTelefone3());
        return contatoModel;
    }

    private DocumentoModel getDocumentoModel(Aluno aluno) {
        DocumentoModel documentoModel = new DocumentoModel();
        documentoModel.setId(aluno.getDocumentos().getId());
        documentoModel.setTituloDeEleitor(aluno.getDocumentos().getTituloDeEleitor());
        documentoModel.setRG(aluno.getDocumentos().getRG());
        documentoModel.setOAB(aluno.getDocumentos().getOAB());
        documentoModel.setCPF(aluno.getDocumentos().getCPF());
        documentoModel.setCREA(aluno.getDocumentos().getCREA());
        documentoModel.setReservista(aluno.getDocumentos().getReservista());
        documentoModel.setCarteiraDeTralho(aluno.getDocumentos().getCarteiraDeTralho());
        return documentoModel;
    }

    private static EnderecoModel getEnderecoModel(Endereco endereco, AlunoModel alunoModel) {
        EnderecoModel enderecoModel = new EnderecoModel();
        enderecoModel.setId(endereco.getId());
        enderecoModel.setAluno(alunoModel);
        enderecoModel.setNumero(endereco.getNumero());
        enderecoModel.setBairro(endereco.getBairro());
        enderecoModel.setPais(endereco.getPais());
        enderecoModel.setRua(endereco.getRua());
        enderecoModel.setCidade(endereco.getCidade());
        enderecoModel.setEstado(endereco.getEstado());
        enderecoModel.setCep(endereco.getCep());
        return enderecoModel;
    }
}
