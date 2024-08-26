package br.com.Tramas3030.car_catalog.modules.company.controllers;

import br.com.Tramas3030.car_catalog.modules.company.dto.CreateCarDTO;
import br.com.Tramas3030.car_catalog.modules.company.entities.CarEntity;
import br.com.Tramas3030.car_catalog.modules.company.useCase.CreateCarUseCase;
import br.com.Tramas3030.car_catalog.modules.company.useCase.DeleteCarUseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CreateCarUseCase createCarUseCase;

    @Autowired
    private DeleteCarUseCase deleteCarUseCase;

    @PostMapping("/")
    @PreAuthorize("hasRole('COMPANY')")
    public ResponseEntity<Object> create(@Valid @RequestBody CreateCarDTO createCarDTO, HttpServletRequest request) {
        try {
            var companyId = request.getAttribute("company_id");
            var carEntity = CarEntity.builder()
                    .name(createCarDTO.getName())
                    .companyId(UUID.fromString(companyId.toString()))
                    .color(createCarDTO.getColor())
                    .description(createCarDTO.getDescription())
                    .modelYear(createCarDTO.getModelYear())
                    .manufacturer(createCarDTO.getManufacturer())
                    .build();

            var result = this.createCarUseCase.execute(carEntity);
            return  ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{carId}")
    @PreAuthorize("hasRole('COMPANY')")
    public ResponseEntity<Object> delete(@PathVariable UUID carId, HttpServletRequest request) {
        try {
            var companyId = request.getAttribute("company_id");
            this.deleteCarUseCase.execute(carId, UUID.fromString(companyId.toString()));
            return ResponseEntity.ok().body("Car deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
