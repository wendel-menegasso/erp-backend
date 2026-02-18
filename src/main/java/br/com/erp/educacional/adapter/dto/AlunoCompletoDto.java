package br.com.erp.educacional.adapter.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlunoCompletoDto {
    private AlunoDto aluno;
    private Integer endereco;
    private Integer contato;
    private Integer documento;
    private Integer curso;
}

