package ar.com.ada.cursarproject.cursarproject.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ParticipantDTO implements Serializable {

    private Long id;
    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "lastname is required")
    private String lastname;

    @NotBlank(message = "gender is required")
    private String gender;

    @Pattern(regexp = "^[0-9a-zA-ZáéíóúÁÉÍÓÚÜüñÑ\\s]*$", message = "address contains not allowed characters")
    @NotBlank(message = "address is required")
    private String address;

    @NotBlank(message = "typeOfRegistration is required")
    private String typeofRegistration;
}
