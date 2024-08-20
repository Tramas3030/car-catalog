package br.com.Tramas3030.car_catalog.modules.client.controllers;

import br.com.Tramas3030.car_catalog.modules.client.repositories.ClientEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {

    @PostMapping("/")
    public void create(@Valid @RequestBody ClientEntity clientEntity) {
        System.out.println("cliente:");
        System.out.println(clientEntity.getEmail());
    }

}
