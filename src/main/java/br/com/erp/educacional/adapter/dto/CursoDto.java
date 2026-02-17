package br.com.erp.educacional.adapter.dto;

import br.com.erp.educacional.domain.entity.commons.Periodo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CursoDto {
    private Integer id;
    private String nome;
    private Periodo periodo;
}
