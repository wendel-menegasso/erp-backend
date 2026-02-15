package br.com.erp.educacional.infrastructure.database.repository;

import br.com.erp.educacional.domain.entity.commons.Documento;
import br.com.erp.educacional.domain.entity.commons.Endereco;
import br.com.erp.educacional.domain.repository.common.DocumentoRepository;
import br.com.erp.educacional.infrastructure.database.model.DocumentoModel;
import br.com.erp.educacional.infrastructure.database.model.EnderecoModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

public class DocumentoRepositoryJPA implements DocumentoRepository {
    @PersistenceContext
    private EntityManager em;


    @Override
    @Transactional
    public void save(Documento documento) {
        DocumentoModel documentoModel = new DocumentoModel();
        documentoModel.setRG(documento.getRG());
        documentoModel.setReservista(documento.getReservista());
        documentoModel.setCREA(documento.getCREA());
        documentoModel.setOAB(documento.getOAB());
        documentoModel.setCPF(documento.getCPF());
        documentoModel.setCarteiraDeTralho(documento.getCarteiraDeTralho());
        documentoModel.setTituloDeEleitor(documento.getTituloDeEleitor());
        em.persist(documentoModel);
    }
}
