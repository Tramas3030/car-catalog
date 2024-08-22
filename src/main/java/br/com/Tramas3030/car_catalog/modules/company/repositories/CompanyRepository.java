package br.com.Tramas3030.car_catalog.modules.company.repositories;

import br.com.Tramas3030.car_catalog.modules.company.entities.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {
    Optional<CompanyEntity> findByNameOrEmail(String name, String email);

    Optional<CompanyEntity> findByName(String name);
}
