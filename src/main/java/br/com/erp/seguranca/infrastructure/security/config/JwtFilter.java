package br.com.erp.seguranca.infrastructure.security.config;

import br.com.erp.seguranca.domain.entity.Token;
import br.com.erp.seguranca.domain.entity.User;
import br.com.erp.seguranca.domain.repository.UserRepository;
import br.com.erp.seguranca.usecases.auth.FindByUsernameWithRolesUseCase;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final FindByUsernameWithRolesUseCase findByUsernameWithRolesUseCase;

    public JwtFilter(FindByUsernameWithRolesUseCase findByUsernameWithRolesUseCase) {
        this.findByUsernameWithRolesUseCase = findByUsernameWithRolesUseCase;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getRequestURI();

        if (path.startsWith("/public")) {
            filterChain.doFilter(request, response);
            return;
        }


        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {

            String token = authHeader.substring(7);
            String username = Token.validate(token); // precisa validar

            if (username != null) {

                if (findByUsernameWithRolesUseCase.executar(username).isPresent()) {
                    User user = findByUsernameWithRolesUseCase.executar(username).get();

                    // Aqui você monta as authorities a partir do banco
                    Set<GrantedAuthority> authorities =
                            user.getRoles().stream()
                                    .flatMap(role -> role.getSubroleList().stream())
                                    .map(sub -> new SimpleGrantedAuthority(sub.getEndpoint()))
                                    .collect(Collectors.toSet());

                    UsernamePasswordAuthenticationToken auth =
                            new UsernamePasswordAuthenticationToken(
                                    user, null, authorities
                            );

                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
            }
        }

        filterChain.doFilter(request, response);
    }
}
