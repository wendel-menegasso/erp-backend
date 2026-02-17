package br.com.erp.educacional.infrastructure.database.repository;

import br.com.erp.educacional.domain.entity.commons.Documento;
import br.com.erp.educacional.domain.repository.common.DocumentoRepository;
import br.com.erp.educacional.infrastructure.database.model.DocumentoModel;
import br.com.erp.seguranca.infrastructure.jpa.UserModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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

    @Override
    public Optional<Documento> findById(int id) {
        var query = em.createQuery(
                "SELECT doc FROM DocumentoModel doc WHERE doc.id = :id",
                DocumentoModel.class
        );
        query.setParameter("id", id);

        return query.getResultStream()
                .findFirst()
                .map(this::toDomain);
    }

    private Documento toDomain(DocumentoModel model) {
        Documento documento = new Documento();
        documento.setOAB(model.getOAB());
        documento.setRG(model.getRG());
        documento.setCPF(model.getCPF());
        documento.setCREA(model.getCREA());
        documento.setReservista(model.getReservista());
        documento.setCarteiraDeTralho(model.getCarteiraDeTralho());
        documento.setTituloDeEleitor(model.getTituloDeEleitor());
        documento.setId(model.getId());
        return documento;
    }
}
