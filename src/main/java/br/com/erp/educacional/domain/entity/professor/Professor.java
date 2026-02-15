package br.com.erp.educacional.domain.entity.professor;

import br.com.erp.educacional.domain.entity.commons.Documento;
import br.com.erp.educacional.domain.entity.commons.Endereco;
import br.com.erp.educacional.domain.entity.contato.Contato;
import br.com.erp.educacional.domain.entity.disciplina.Disciplina;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Professor {
    private String nome;
    private String pai;
    private String mae;
    private Endereco endereco;
    private Documento documentos;
    private Contato contato;
    private List<Titulo> titulos;
    private int numeroDeMatricula;
    private List<Disciplina> disciplinas;
}
