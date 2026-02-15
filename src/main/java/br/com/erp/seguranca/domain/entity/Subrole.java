package br.com.erp.seguranca.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Subrole {
    private Long id;

    private String endpoint;
}
