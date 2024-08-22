package br.com.Tramas3030.car_catalog.modules.company.useCase;

import br.com.Tramas3030.car_catalog.exceptions.CarFoundException;
import br.com.Tramas3030.car_catalog.modules.company.entities.CarEntity;
import br.com.Tramas3030.car_catalog.modules.company.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCarUseCase {

    @Autowired
    private CarRepository carRepository;

    public CarEntity execute(CarEntity carEntity) {
        this.carRepository.findByNameAndColor(carEntity.getName(), carEntity.getColor())
                .ifPresent(car -> {
                    throw new CarFoundException();
                });

        return this.carRepository.save(carEntity);
    }

}
