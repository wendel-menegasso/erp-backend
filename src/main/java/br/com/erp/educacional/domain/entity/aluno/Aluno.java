package br.com.erp.educacional.domain.entity.aluno;

import br.com.erp.educacional.domain.entity.commons.Documento;
import br.com.erp.educacional.domain.entity.commons.Endereco;
import br.com.erp.educacional.domain.entity.contato.Contato;
import br.com.erp.educacional.domain.entity.curso.Curso;
import br.com.erp.educacional.domain.entity.turma.Turma;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Aluno {
    private String nome;
    private String pai;
    private String mae;
    private Endereco endereco;
    private Contato contato;
    private Documento documentos;
    private int numeroDeMatricula;
    private boolean bolsista;
    private Curso curso;
    private int valorBolsa;;
    private Turma turma;
}
