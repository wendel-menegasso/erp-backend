package br.com.erp.seguranca.adapter.repository;

import br.com.erp.seguranca.domain.entity.Role;
import br.com.erp.seguranca.domain.entity.User;
import br.com.erp.seguranca.domain.repository.UserRepository;
import br.com.erp.seguranca.infrastructure.jpa.UserModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserRepositoryJpa implements UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<User> findByUsername(String username) {
        var query = em.createQuery(
                "SELECT u FROM UserModel u JOIN FETCH u.roles WHERE u.username = :username",
                UserModel.class
        );
        query.setParameter("username", username);

        return query.getResultStream()
                .findFirst()
                .map(this::toDomain);
    }

    @Override
    public Optional<User> findByUsernameAndPassword(String username, String password) {
        var query = em.createQuery(
                "SELECT u FROM UserModel u WHERE u.username = :username AND u.passwordHash = :password",
                UserModel.class
        );
        query.setParameter("username", username);
        query.setParameter("password", password);

        return query.getResultStream()
                .findFirst()
                .map(this::toDomain);
    }

    @Override
    @Transactional
    public Optional<User> findByUsernameWithRoles(String username) {
        var query = em.createQuery(
                "SELECT DISTINCT u FROM UserModel u " +
                        "JOIN u.roles r " +
                        "JOIN r.subroles s " +
                        "ON u.username = :username",
                UserModel.class
        );
        query.setParameter("username", username);

        Stream<UserModel> res = query.getResultStream();
        Optional<UserModel> userModel = res.findFirst();

        return userModel.map(this::toDomainWithRolesAndSubroles);
    }


    private User toDomainWithRolesAndSubroles(UserModel model) {

        var roles = model.getRoles().stream()
                .map(roleModel -> new Role(
                        roleModel.getId(),
                        roleModel.getSubroles().stream()
                                .map(sub -> new br.com.erp.seguranca.domain.entity.Subrole(
                                        sub.getId(),
                                        sub.getEndpoint()
                                ))
                                .collect(Collectors.toSet())
                ))
                .collect(Collectors.toSet());

        return new User(
                model.getId(),
                model.getUsername(),
                model.getPasswordHash(),
                roles
        );
    }




    private User toDomain(UserModel model) {
        var roles = model.getRoles().stream()
                .map(r -> new Role(r.getId()))
                .collect(Collectors.toSet());

        return new User(
                model.getId(),
                model.getUsername(),
                model.getPasswordHash(),
                roles
        );
    }
}
