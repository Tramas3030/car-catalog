package br.com.Tramas3030.car_catalog.modules.client.useCase;

import br.com.Tramas3030.car_catalog.modules.client.dto.ProfileClientResponseDTO;
import br.com.Tramas3030.car_catalog.modules.client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProfileClientUseCase {

    @Autowired
    private ClientRepository clientRepository;

    public ProfileClientResponseDTO execute(UUID idClient) {
        var client = this.clientRepository.findById(idClient)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return ProfileClientResponseDTO.builder()
                .id(client.getId())
                .email(client.getEmail())
                .name(client.getName())
                .username(client.getUsername())
                .build();
    }

}
