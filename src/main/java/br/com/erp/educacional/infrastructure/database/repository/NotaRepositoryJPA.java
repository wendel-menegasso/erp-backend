package br.com.erp.educacional.infrastructure.database.repository;

import br.com.erp.educacional.domain.entity.disciplina.Disciplina;
import br.com.erp.educacional.domain.entity.nota.Nota;
import br.com.erp.educacional.domain.entity.professor.Titulo;
import br.com.erp.educacional.domain.repository.nota.NotaRepository;
import br.com.erp.educacional.infrastructure.database.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;

public class NotaRepositoryJPA implements NotaRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Nota nota) {
        NotaModel notaModel = new NotaModel();
        notaModel.setId(nota.getId());
        notaModel.setNota(nota.getNota());
        notaModel.setPeso(nota.getPeso());
        AlunoModel alunoModel = new AlunoModel();
        fillAluno(alunoModel, nota);
        notaModel.setAluno(alunoModel);
        ProfessorModel professorModel = new ProfessorModel();
        fillProfessor(professorModel, nota);
        notaModel.setProfessor(professorModel);
        DisciplinaModel disciplinaModel = new DisciplinaModel();
        disciplinaModel.setNome(nota.getDisciplina().getNome());
        notaModel.setDisciplina(disciplinaModel);
        em.persist(notaModel);
    }

    private void fillAluno(AlunoModel alunoModel, Nota nota) {
        alunoModel.setBolsista(nota.getAluno().isBolsista());
        alunoModel.setPai((nota.getAluno().getPai()));
        alunoModel.setMae(nota.getAluno().getMae());
        alunoModel.setPai((nota.getAluno().getPai()));

        alunoModel.setCurso(nota.getAluno().getCurso());

        EnderecoModel enderecoModel = getEnderecoModel(nota);
        alunoModel.setEnderecos(enderecoModel);

        ContatoModel contatoModel = getContatoModel(nota);
        alunoModel.setContatos(contatoModel);

        DocumentoModel documentoModel = getModel(nota);
        alunoModel.setDocumentos(documentoModel);

        TurmaModel turmaModel = new TurmaModel();
        turmaModel.setNome(nota.getAluno().getTurma().getNome());
        turmaModel.setPeriodo(nota.getAluno().getTurma().getPeriodo());
        alunoModel.setTurma(turmaModel);
    }

    private static ContatoModel getContatoModel(Nota nota) {
        ContatoModel contatoModel = new ContatoModel();
        contatoModel.setEmail1(nota.getAluno().getContato().getEmail1());
        contatoModel.setEmail2(nota.getAluno().getContato().getEmail2());
        contatoModel.setEmail3(nota.getAluno().getContato().getEmail3());
        contatoModel.setTelefone1(nota.getAluno().getContato().getTelefone1());
        contatoModel.setTelefone2(nota.getAluno().getContato().getTelefone2());
        contatoModel.setTelefone3(nota.getAluno().getContato().getTelefone3());
        return contatoModel;
    }

    private static DocumentoModel getModel(Nota nota) {
        DocumentoModel documentoModel = new DocumentoModel();
        documentoModel.setRG(nota.getAluno().getDocumentos().getRG());
        documentoModel.setCPF(nota.getAluno().getDocumentos().getCPF());
        documentoModel.setCarteiraDeTralho(nota.getAluno().getDocumentos().getCarteiraDeTralho());
        documentoModel.setOAB(nota.getAluno().getDocumentos().getOAB());
        documentoModel.setTituloDeEleitor(nota.getAluno().getDocumentos().getTituloDeEleitor());
        documentoModel.setCREA(nota.getAluno().getDocumentos().getCREA());
        documentoModel.setReservista(nota.getAluno().getDocumentos().getReservista());
        return documentoModel;
    }

    private static EnderecoModel getEnderecoModels(Nota nota) {
        EnderecoModel enderecoModel = new EnderecoModel();
        enderecoModel.setCep(nota.getAluno().getEndereco().getCep());
        enderecoModel.setPais(nota.getAluno().getEndereco().getPais());
        enderecoModel.setCidade(nota.getAluno().getEndereco().getCidade());
        enderecoModel.setRua(nota.getAluno().getEndereco().getRua());
        enderecoModel.setEstado(nota.getAluno().getEndereco().getEstado());
        enderecoModel.setBairro(nota.getAluno().getEndereco().getBairro());
        enderecoModel.setNumero(nota.getAluno().getEndereco().getNumero());
        enderecoModel.setNumero(nota.getAluno().getEndereco().getNumero());
        return enderecoModel;
    }

    private void fillProfessor(ProfessorModel professorModel, Nota nota) {
        professorModel.setPai((nota.getProfessor().getPai()));
        professorModel.setMae(nota.getProfessor().getMae());
        professorModel.setPai((nota.getProfessor().getPai()));
        
        EnderecoModel enderecoModel = getEnderecoModel(nota);
        professorModel.setEnderecos(enderecoModel);

        ContatoModel contatoModel = getContatoModel(nota);
        contatoModel.setEmail1(nota.getProfessor().getContato().getEmail1());
        contatoModel.setEmail2(nota.getProfessor().getContato().getEmail2());
        contatoModel.setEmail3(nota.getProfessor().getContato().getEmail3());
        contatoModel.setTelefone1(nota.getProfessor().getContato().getTelefone1());
        contatoModel.setTelefone2(nota.getProfessor().getContato().getTelefone2());
        contatoModel.setTelefone3(nota.getProfessor().getContato().getTelefone3());
        professorModel.setContatos(contatoModel);

        DocumentoModel documentoModel = getDocumentoModel(nota);
        professorModel.setDocumentos(documentoModel);

        List<TituloModel> tituloModels = new ArrayList<>();
        for (Titulo titulo: nota.getProfessor().getTitulos()){
            TituloModel tituloModel = new TituloModel();
            tituloModel.setNome(titulo.getTitulo());
            tituloModels.add(tituloModel);
        }
        professorModel.setTitulos(tituloModels);

        List<DisciplinaModel> disciplinaModels = new ArrayList<>();
        for (Disciplina disciplina : nota.getProfessor().getDisciplinas()) {
            DisciplinaModel disciplinaModel = new DisciplinaModel();
            disciplinaModel.setNome(disciplina.getNome());
            disciplinaModels.add(disciplinaModel);
        }
        professorModel.setDisciplinas(disciplinaModels);
    }

    private static DocumentoModel getDocumentoModel(Nota nota) {
        DocumentoModel documentoModel = new DocumentoModel();
        documentoModel.setRG(nota.getProfessor().getDocumentos().getRG());
        documentoModel.setCPF(nota.getProfessor().getDocumentos().getCPF());
        documentoModel.setCarteiraDeTralho(nota.getProfessor().getDocumentos().getCarteiraDeTralho());
        documentoModel.setOAB(nota.getProfessor().getDocumentos().getOAB());
        documentoModel.setTituloDeEleitor(nota.getProfessor().getDocumentos().getTituloDeEleitor());
        documentoModel.setCREA(nota.getProfessor().getDocumentos().getCREA());
        documentoModel.setReservista(nota.getProfessor().getDocumentos().getReservista());
        return documentoModel;
    }

    private static EnderecoModel getEnderecoModel(Nota nota) {
        EnderecoModel enderecoModel = new EnderecoModel();
        enderecoModel.setCep(nota.getProfessor().getEndereco().getCep());
        enderecoModel.setPais(nota.getProfessor().getEndereco().getPais());
        enderecoModel.setCidade(nota.getProfessor().getEndereco().getCidade());
        enderecoModel.setRua(nota.getProfessor().getEndereco().getRua());
        enderecoModel.setEstado(nota.getProfessor().getEndereco().getEstado());
        enderecoModel.setBairro(nota.getProfessor().getEndereco().getBairro());
        enderecoModel.setNumero(nota.getProfessor().getEndereco().getNumero());
        enderecoModel.setNumero(nota.getProfessor().getEndereco().getNumero());
        return enderecoModel;
    }
}
