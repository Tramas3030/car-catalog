package br.com.Tramas3030.car_catalog.modules.client.useCase;

import br.com.Tramas3030.car_catalog.modules.client.dto.AuthClientRequestDTO;
import br.com.Tramas3030.car_catalog.modules.client.dto.AuthClientResponseDTO;
import br.com.Tramas3030.car_catalog.modules.client.repositories.ClientRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

@Service
public class AuthClientUseCase {

    @Value("${security.token.secret.candidate}")
    private String secretKey;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthClientResponseDTO execute(AuthClientRequestDTO authClientRequestDTO) throws AuthenticationException {
        var client = this.clientRepository.findByUsername(authClientRequestDTO.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Username/password incorrect"));

        var passwordMatches = this.passwordEncoder
                .matches(authClientRequestDTO.getPassword(), client.getPassword());

        if(!passwordMatches) {
            throw new BadCredentialsException("Invalid password");
        }

        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        var expiresIn = Instant.now().plus(Duration.ofMinutes(10));
        var token = JWT.create()
                .withIssuer("Car catalog")
                .withSubject(client.getId().toString())
                .withClaim("roles", Arrays.asList("client"))
                .withExpiresAt(expiresIn)
                .sign(algorithm);

        return AuthClientResponseDTO.builder()
                .access_token(token)
                .expires_in(expiresIn.toEpochMilli())
                .build();
    }
}