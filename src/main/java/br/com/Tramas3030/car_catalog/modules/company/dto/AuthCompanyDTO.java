package br.com.Tramas3030.car_catalog.modules.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthCompanyDTO {
    private String name;
    private String password;
}
