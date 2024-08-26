package br.com.Tramas3030.car_catalog.modules.company.useCase;

import br.com.Tramas3030.car_catalog.modules.company.dto.UpdateCarDTO;
import br.com.Tramas3030.car_catalog.modules.company.entities.CarEntity;
import br.com.Tramas3030.car_catalog.modules.company.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UpdateCarUseCase {

    @Autowired
    private CarRepository carRepository;

    public CarEntity execute(UUID carId, UUID companyId, UpdateCarDTO updateCarDTO) {
        var car = this.carRepository.findByIdAndCompanyId(carId, companyId)
                .orElseThrow(() -> new RuntimeException("Car not found"));

        var uptadedCarInformations = CarEntity.builder()
                .id(car.getId())
                .name(updateCarDTO.getName() != null ? updateCarDTO.getName() : car.getName())
                .color(updateCarDTO.getColor() != null ? updateCarDTO.getColor() : car.getColor())
                .description(updateCarDTO.getDescription() != null ? updateCarDTO.getDescription() : car.getDescription())
                .modelYear(updateCarDTO.getModelYear() != null ? updateCarDTO.getModelYear() : car.getModelYear())
                .manufacturer(updateCarDTO.getManufacturer() != null ? updateCarDTO.getManufacturer() : car.getManufacturer())
                .companyId(car.getCompanyId())
                .build();

        return this.carRepository.save(uptadedCarInformations);
    }

}
