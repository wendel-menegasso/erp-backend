package br.com.erp.educacional.domain.entity.mensalidade;

import br.com.erp.educacional.domain.entity.aluno.Aluno;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Mensalidade {
    private int id;
    private Aluno aluno;
    private BigDecimal valor;
    boolean pagoOuNao;
}
