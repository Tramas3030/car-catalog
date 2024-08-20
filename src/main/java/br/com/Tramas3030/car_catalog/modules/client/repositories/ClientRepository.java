package br.com.Tramas3030.car_catalog.modules.client.repositories;

import br.com.Tramas3030.car_catalog.modules.client.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<ClientEntity, UUID> {



}
