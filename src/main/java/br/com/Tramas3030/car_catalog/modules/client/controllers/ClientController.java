package br.com.Tramas3030.car_catalog.modules.client.controllers;

import br.com.Tramas3030.car_catalog.modules.client.entities.ClientEntity;
import br.com.Tramas3030.car_catalog.modules.client.useCase.CreateClientUseCase;
import br.com.Tramas3030.car_catalog.modules.client.useCase.ProfileClientUseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private CreateClientUseCase createClientUseCase;

    @Autowired
    private ProfileClientUseCase profileClientUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody ClientEntity clientEntity) {
        try {
            var result = this.createClientUseCase.execute(clientEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    @PreAuthorize("hasRole('CLIENT')")
    public ResponseEntity<Object> get(HttpServletRequest request) {
        var idClient = request.getAttribute("client_id");

        try {
            var profile = this.profileClientUseCase.execute(UUID.fromString(idClient.toString()));
            return ResponseEntity.ok().body(profile);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
