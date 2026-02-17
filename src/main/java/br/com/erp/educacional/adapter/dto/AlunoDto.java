package br.com.erp.educacional.adapter.dto;

import br.com.erp.educacional.domain.entity.commons.Documento;
import br.com.erp.educacional.domain.entity.commons.Endereco;
import br.com.erp.educacional.domain.entity.contato.Contato;
import br.com.erp.educacional.domain.entity.curso.Curso;
import br.com.erp.educacional.domain.entity.turma.Turma;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AlunoDto {
    private String nome;
    private String pai;
    private String mae;
    private Endereco endereco;
    private Contato contato;
    private Documento documentos;
    private Integer numeroDeMatricula;
    private Boolean bolsista;
    private Curso curso;
    private Integer valorBolsa;;
    private Turma turma;
}
