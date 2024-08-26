package br.com.Tramas3030.car_catalog.modules.company.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarDTO {

    private String name;
    private String color;
    private String description;
    private String modelYear;
    private String manufacturer;

}
