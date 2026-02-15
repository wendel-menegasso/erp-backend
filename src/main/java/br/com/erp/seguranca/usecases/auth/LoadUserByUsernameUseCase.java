package br.com.erp.seguranca.usecases.auth;

import br.com.erp.seguranca.domain.entity.User;
import br.com.erp.seguranca.domain.repository.UserRepository;

import java.util.Optional;

public class LoadUserByUsernameUseCase {

    private final UserRepository userRepository;

    public LoadUserByUsernameUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> executar(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> executar(String username, String userPassword) {
        return userRepository.findByUsernameAndPassword(username, userPassword);
    }
}

