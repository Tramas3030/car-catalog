package br.com.Tramas3030.car_catalog.modules.client.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthClientResponseDTO {

    private String access_token;
    private Long expires_in;

}
