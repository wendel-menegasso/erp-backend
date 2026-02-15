package br.com.erp.seguranca.infrastructure.jpa.config;

import br.com.erp.educacional.domain.repository.common.EnderecoRepository;
import br.com.erp.educacional.usecases.endereco.CasoDeUsoCriarEndereco;
import br.com.erp.seguranca.adapter.repository.UserRepositoryJpa;
import br.com.erp.seguranca.domain.repository.UserRepository;
import br.com.erp.seguranca.infrastructure.security.config.JwtFilter;
import br.com.erp.seguranca.usecases.auth.FindByUsernameWithRolesUseCase;
import br.com.erp.seguranca.usecases.auth.LoadUserByUsernameUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanJPAConfig {
    @Bean
    public UserRepository userRepository() {
        return new UserRepositoryJpa();
    }

    @Bean
    public LoadUserByUsernameUseCase loadUserByUsernameUseCase(UserRepository repo) {
        return new LoadUserByUsernameUseCase(repo);
    }

    @Bean
    public FindByUsernameWithRolesUseCase findByUsernameWithRolesUseCase(UserRepository repo) {
        return new FindByUsernameWithRolesUseCase(repo);
    }
}
