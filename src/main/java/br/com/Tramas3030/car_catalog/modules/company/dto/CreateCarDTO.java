package br.com.Tramas3030.car_catalog.modules.company.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateCarDTO {

    @NotBlank(message = "O campo nome é obrigatório")
    private String name;

    @NotBlank(message = "O campo cor é obrigatório")
    private String color;

    @NotBlank(message = "O campo descrição é obrigatório")
    private String description;

    @NotBlank(message = "O campo ano modelo é obrigatório")
    private String modelYear;

    @NotBlank(message = "O campo fabricante é obrigatório")
    private String manufacturer;

}
