package br.com.erp.educacional.infrastructure.database.repository;

import br.com.erp.educacional.domain.entity.disciplina.Disciplina;
import br.com.erp.educacional.domain.repository.disciplina.DisciplinaRepository;
import br.com.erp.educacional.infrastructure.database.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public class DisciplinaRepoCustom implements DisciplinaRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    @Transactional
    public void save(Disciplina disciplina)
    {
        DisciplinaModel disciplinaModel = new DisciplinaModel();
        disciplinaModel.setNome(disciplina.getNome());
        disciplinaModel.setId(disciplina.getId());
        ProfessorModel professorModel = new ProfessorModel();
        
        List<DisciplinaModel> disciplinaModelList = disciplina.getProfessor().getDisciplinas().stream().map(disciplina1 ->
        {
            DisciplinaModel disc = new DisciplinaModel();
            disc.setProfessor(professorModel);
            disc.setNome(disciplina1.getNome());
            return disc;
        }).toList();
        professorModel.setDisciplinas(disciplinaModelList);

        DocumentoModel documentoModel = getDocumentoModel(disciplina);
        professorModel.setDocumentos(documentoModel);

        List<TituloModel> tituloModelList = disciplina.getProfessor().getTitulos().stream().map(titulo ->
        {
            TituloModel tituloModel = new TituloModel();
            tituloModel.setProfessor(professorModel);
            tituloModel.setNome(titulo.getTitulo());
            return tituloModel;
        }).toList();
        professorModel.setTitulos(tituloModelList);

        professorModel.setPai(disciplina.getProfessor().getPai());
        professorModel.setMae(disciplina.getProfessor().getMae());
        professorModel.setNome(disciplina.getProfessor().getNome());
        professorModel.setNumeroDeMatricula(disciplina.getProfessor().getNumeroDeMatricula());

        ContatoModel contatoModel = getContatoModel(disciplina);
        professorModel.setContatos(contatoModel);

        EnderecoModel enderecoModel = getEnderecoModel(disciplina, professorModel);
        professorModel.setEnderecos(enderecoModel);
        
        disciplinaModel.setProfessor(professorModel);
        em.persist(disciplinaModel);
    }

    private static EnderecoModel getEnderecoModel(Disciplina disciplina, ProfessorModel professorModel) {
        EnderecoModel enderecoModel = new EnderecoModel();
        enderecoModel.setNumero(disciplina.getProfessor().getEndereco().getNumero());
        enderecoModel.setBairro(disciplina.getProfessor().getEndereco().getBairro());
        enderecoModel.setRua(disciplina.getProfessor().getEndereco().getBairro());
        enderecoModel.setPais(disciplina.getProfessor().getEndereco().getBairro());
        enderecoModel.setEstado(disciplina.getProfessor().getEndereco().getBairro());
        enderecoModel.setCideda(disciplina.getProfessor().getEndereco().getBairro());
        enderecoModel.setCep(disciplina.getProfessor().getEndereco().getBairro());

        enderecoModel.setProfessor(professorModel);
        return enderecoModel;
    }

    private static ContatoModel getContatoModel(Disciplina disciplina) {
        ContatoModel contatoModel = new ContatoModel();
        contatoModel.setTelefone1(disciplina.getProfessor().getContato().getTelefone1());
        contatoModel.setTelefone2(disciplina.getProfessor().getContato().getTelefone2());
        contatoModel.setTelefone3(disciplina.getProfessor().getContato().getTelefone3());
        contatoModel.setEmail1(disciplina.getProfessor().getContato().getEmail1());
        contatoModel.setEmail2(disciplina.getProfessor().getContato().getEmail2());
        contatoModel.setEmail3(disciplina.getProfessor().getContato().getEmail3());
        return contatoModel;
    }

    private static DocumentoModel getDocumentoModel(Disciplina disciplina) {
        DocumentoModel documentoModel = new DocumentoModel();
        documentoModel.setRG(disciplina.getProfessor().getDocumentos().getRG());
        documentoModel.setCPF(disciplina.getProfessor().getDocumentos().getCPF());
        documentoModel.setReservista(disciplina.getProfessor().getDocumentos().getReservista());
        documentoModel.setCREA(disciplina.getProfessor().getDocumentos().getCREA());
        documentoModel.setOAB(disciplina.getProfessor().getDocumentos().getOAB());
        documentoModel.setTituloDeEleitor(disciplina.getProfessor().getDocumentos().getTituloDeEleitor());
        documentoModel.setCarteiraDeTralho(disciplina.getProfessor().getDocumentos().getCarteiraDeTralho());
        return documentoModel;
    }

    public boolean disciplinaExiste(Disciplina disciplina) {
        String jpql = "SELECT COUNT(d) FROM DisciplinaModel d WHERE LOWER(d.nome) = LOWER(:nome)";

        Long count = em.createQuery(jpql, Long.class)
                .setParameter("nome", disciplina.getNome())
                .getSingleResult();

        return count > 0;
    }
}