package br.com.Tramas3030.car_catalog.modules.client.useCase;

import br.com.Tramas3030.car_catalog.exceptions.UserFoundException;
import br.com.Tramas3030.car_catalog.modules.client.entities.ClientEntity;
import br.com.Tramas3030.car_catalog.modules.client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateClientUseCase {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ClientEntity execute(ClientEntity clientEntity) {
        this.clientRepository.findByUsernameOrEmail(clientEntity.getUsername(), clientEntity.getEmail())
                .ifPresent(user -> {
                    throw new UserFoundException();
                });

        var encryptedPassword = passwordEncoder.encode(clientEntity.getPassword());
        clientEntity.setPassword(encryptedPassword);

        return this.clientRepository.save(clientEntity);
    }

}
