package br.com.Tramas3030.car_catalog.modules.client.controllers;

import br.com.Tramas3030.car_catalog.modules.client.dto.AuthClientRequestDTO;
import br.com.Tramas3030.car_catalog.modules.client.useCase.AuthClientUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthClientController {

    @Autowired
    private AuthClientUseCase authClientUseCase;

    @PostMapping("/client")
    public ResponseEntity<Object> auth(@RequestBody AuthClientRequestDTO authClientRequestDTO) {
        try {
            var token = this.authClientUseCase.execute(authClientRequestDTO);
            return ResponseEntity.ok().body(token);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

}
