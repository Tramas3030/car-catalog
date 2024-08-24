package br.com.Tramas3030.car_catalog.modules.company.controllers;

import br.com.Tramas3030.car_catalog.modules.company.entities.CompanyEntity;
import br.com.Tramas3030.car_catalog.modules.company.useCase.CreateCompanyUseCase;
import br.com.Tramas3030.car_catalog.modules.company.useCase.GetCarsByCompanyUseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CreateCompanyUseCase createCompanyUseCase;

    @Autowired
    private GetCarsByCompanyUseCase getCarsByCompanyUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CompanyEntity companyEntity) {
        try {
            var result = this.createCompanyUseCase.execute(companyEntity);
            return  ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/cars")
    @PreAuthorize("hasRole('COMPANY')")
    public ResponseEntity<Object> get(HttpServletRequest request) {
        try {
            var companyId = request.getAttribute("company_id");
            System.out.println("------- ID DA COMPANY -------");
            System.out.println(companyId);
            var result = this.getCarsByCompanyUseCase.execute(UUID.fromString(companyId.toString()));

            System.out.println("------- RESULTADO DA PESQUISA -------");
            System.out.println(result);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
