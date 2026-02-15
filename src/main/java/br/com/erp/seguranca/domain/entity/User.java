package br.com.erp.seguranca.domain.entity;

import java.util.Set;

public class User {
    private final String id;
    private final String username;
    private final String passwordHash;
    private final Set<Role> roles;

    public User(String id, String username, String passwordHash, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
        this.roles = roles;
    }

    public String getId() { return id; }
    public String getUsername() { return username; }
    public String getPasswordHash() { return passwordHash; }
    public Set<Role> getRoles() { return roles; }
}
