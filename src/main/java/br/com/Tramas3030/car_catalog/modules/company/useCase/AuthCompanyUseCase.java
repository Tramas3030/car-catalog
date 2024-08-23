package br.com.Tramas3030.car_catalog.modules.company.useCase;

import br.com.Tramas3030.car_catalog.modules.company.dto.AuthCompanyDTO;
import br.com.Tramas3030.car_catalog.modules.company.dto.AuthCompanyResponseDTO;
import br.com.Tramas3030.car_catalog.modules.company.repositories.CompanyRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.AuthenticationException;

import java.time.Duration;
import java.time.Instant;

@Service
public class AuthCompanyUseCase {

    @Value("${security.token.secret}")
    private String secretKey;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthCompanyResponseDTO execute(AuthCompanyDTO authCompanyDTO) throws AuthenticationException {
        var company = this.companyRepository.findByName(authCompanyDTO.getName())
                .orElseThrow(() -> new UsernameNotFoundException("Company not found"));

        var passwordMatches = this.passwordEncoder.matches(authCompanyDTO.getPassword(), company.getPassword());

        if(!passwordMatches) {
            throw new BadCredentialsException("Invalid password");
        }

        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        var expiresIn = Instant.now().plus(Duration.ofHours(2));

        var token = JWT.create().withIssuer("Car catalog")
                .withExpiresAt(expiresIn)
                .withClaim("roles", "COMPANY")
                .withSubject(company.getId().toString())
                .sign(algorithm);

        return AuthCompanyResponseDTO.builder()
                .access_token(token)
                .expires_in(expiresIn.toEpochMilli())
                .build();
    }

}
