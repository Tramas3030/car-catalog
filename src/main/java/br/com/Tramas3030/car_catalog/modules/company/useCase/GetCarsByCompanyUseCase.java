package br.com.Tramas3030.car_catalog.modules.company.useCase;

import br.com.Tramas3030.car_catalog.modules.company.dto.GetCarsByCompanyDTO;
import br.com.Tramas3030.car_catalog.modules.company.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class GetCarsByCompanyUseCase {

    @Autowired
    private CarRepository carRepository;

    public List<GetCarsByCompanyDTO> execute(UUID companyId) {
        var result = this.carRepository.findAllByCompanyId(companyId);

        List<GetCarsByCompanyDTO> getCarsByCompanyDTO;

        getCarsByCompanyDTO = result.stream().map(car ->
                GetCarsByCompanyDTO.builder()
                        .id(car.getId())
                        .name(car.getName())
                        .color(car.getColor())
                        .createdAt(car.getCreatedAt())
                        .manufacturer(car.getManufacturer())
                        .description(car.getDescription())
                        .modelYear(car.getModelYear())
                        .build()
                ).collect(Collectors.toList());

        return getCarsByCompanyDTO;
    }

}
