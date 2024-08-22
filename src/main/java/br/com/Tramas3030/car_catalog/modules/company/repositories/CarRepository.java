package br.com.Tramas3030.car_catalog.modules.company.repositories;

import br.com.Tramas3030.car_catalog.modules.company.entities.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CarRepository extends JpaRepository<CarEntity, UUID> {
    Optional<CarEntity> findByNameAndColor(String name, String color);
}
