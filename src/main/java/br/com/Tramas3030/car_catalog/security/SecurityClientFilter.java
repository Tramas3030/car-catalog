package br.com.Tramas3030.car_catalog.security;

import br.com.Tramas3030.car_catalog.providers.JWTClientProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class SecurityClientFilter extends OncePerRequestFilter {

    @Autowired
    private JWTClientProvider jwtClientProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");

        if (request.getRequestURI().startsWith("/client/")) {
            if(header != null) {
                var token = this.jwtClientProvider.validateToken(header);

                if(token == null) {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    return;
                }

                request.setAttribute("client_id", token.getSubject());
                var roles = token.getClaim("roles").asList(Object.class);

                var grants = roles.stream()
                        .map(role -> new SimpleGrantedAuthority("ROLE_"+role.toString().toUpperCase()))
                        .toList();


                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(token.getSubject(), null, grants);

                SecurityContextHolder.getContext().setAuthentication(auth);
            }

        }



        filterChain.doFilter(request, response);
    }

}
