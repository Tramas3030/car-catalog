package br.com.Tramas3030.car_catalog.modules.client.useCase;

import br.com.Tramas3030.car_catalog.exceptions.UserFoundException;
import br.com.Tramas3030.car_catalog.modules.client.entities.ClientEntity;
import br.com.Tramas3030.car_catalog.modules.client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateClientUseCase {

    @Autowired
    private ClientRepository clientRepository;

    public ClientEntity execute(ClientEntity clientEntity) {
        this.clientRepository.findByUsernameOrEmail(clientEntity.getUsername(), clientEntity.getEmail())
                .ifPresent(user -> {
                    throw new UserFoundException();
                });

        return this.clientRepository.save(clientEntity);
    }

}
