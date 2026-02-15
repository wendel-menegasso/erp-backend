package br.com.erp.seguranca.domain.repository;

import br.com.erp.seguranca.domain.entity.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUsername(String username);
    Optional<User> findByUsernameAndPassword(String username, String password);
    Optional<User> findByUsernameWithRoles(String username);
}
