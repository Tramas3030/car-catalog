package br.com.Tramas3030.car_catalog.modules.company.controllers;

import br.com.Tramas3030.car_catalog.modules.company.entities.CarEntity;
import br.com.Tramas3030.car_catalog.modules.company.useCase.CreateCarUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CreateCarUseCase createCarUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CarEntity carEntity) {
        try {
            var result = this.createCarUseCase.execute(carEntity);
            return  ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
