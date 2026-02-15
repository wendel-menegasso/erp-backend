package br.com.erp.seguranca.domain.entity;

import lombok.Getter;

import java.util.Set;

@Getter
public class Role {
    private String name;
    private int id;
    private Set<Subrole> subroleList;
    public Role(String name) {
        this.name = name;
    }

    public Role(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Role(int id) {
        this.id = id;
    }

    public Role(int id, Set<Subrole> subroles) {
        this.id = id;
        this.subroleList = subroles;
    }
}
