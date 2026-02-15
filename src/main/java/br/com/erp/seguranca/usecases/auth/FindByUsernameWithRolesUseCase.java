package br.com.erp.seguranca.usecases.auth;

import br.com.erp.seguranca.domain.entity.User;
import br.com.erp.seguranca.domain.repository.UserRepository;

import java.util.Optional;

public class FindByUsernameWithRolesUseCase {
    private final UserRepository userRepository;

    public FindByUsernameWithRolesUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> executar(String username) {
        return userRepository.findByUsernameWithRoles(username);
    }
}
