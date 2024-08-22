package br.com.Tramas3030.car_catalog.modules.company.dto;

import lombok.Data;

@Data
public class CreateCarDTO {

    private String name;
    private String color;
    private String description;
    private String modelYear;
    private String manufacturer;

}
