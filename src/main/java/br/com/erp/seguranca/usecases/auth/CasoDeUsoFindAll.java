package br.com.erp.seguranca.usecases.auth;

import br.com.erp.seguranca.domain.entity.User;
import br.com.erp.seguranca.domain.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class CasoDeUsoFindAll {
    private final UserRepository userRepository;

    public CasoDeUsoFindAll(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> executar() {
        return userRepository.findAll();
    }
}
