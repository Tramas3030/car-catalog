package br.com.Tramas3030.car_catalog.modules.client.controllers;

import br.com.Tramas3030.car_catalog.modules.client.entities.ClientEntity;
import br.com.Tramas3030.car_catalog.modules.client.repositories.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping("/")
    public ClientEntity create(@Valid @RequestBody ClientEntity clientEntity) {
        return this.clientRepository.save(clientEntity);
    }

}
