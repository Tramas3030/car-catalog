package br.com.Tramas3030.car_catalog.modules.client.repositories;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Data
public class ClientEntity {

    private UUID id;
    private String name;

    @NotBlank()
    @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaços")
    private String username;

    @Email(message = "O campo [email] deve conter um email válido")
    private String email;

    @Length(min = 5, max = 100, message = "A senha deve conter entre (5) e (100) caracteres")
    private String password;

}
