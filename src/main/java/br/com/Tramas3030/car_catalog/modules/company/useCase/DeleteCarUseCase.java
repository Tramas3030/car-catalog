package br.com.Tramas3030.car_catalog.modules.company.useCase;

import br.com.Tramas3030.car_catalog.modules.company.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteCarUseCase {

    @Autowired
    private CarRepository carRepository;

    public void execute(UUID carId, UUID companyId) {
        var car = this.carRepository.findByIdAndCompanyId(carId, companyId)
                .orElseThrow(() -> new RuntimeException("Car not found or does not belong to the company"));

        this.carRepository.delete(car);
    }

}
