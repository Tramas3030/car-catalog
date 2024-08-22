package br.com.Tramas3030.car_catalog.modules.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthClientRequestDTO {

    private String username;
    private String password;

}
