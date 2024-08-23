package br.com.Tramas3030.car_catalog.modules.client.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileClientResponseDTO {

    private String name;
    private String username;
    private String email;
    private UUID id;

}
