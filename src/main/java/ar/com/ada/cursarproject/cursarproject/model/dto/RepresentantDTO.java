package ar.com.ada.cursarproject.cursarproject.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class RepresentantDTO implements Serializable {

    private Long id;

    @NotBlank(message = "name is required")
    private String name;
    @NotBlank(message = "lastname is required")
    private String lastname;

    @Pattern(regexp = "^(0|[1-9][0-9]*)$")
    @NotNull(message = "dni is required")
    private Integer dni;

    @NotBlank(message = "position is required")
    private String position;

    @NotBlank(message = "company is required")
    private CompanyDTO company;

    public RepresentantDTO(Long id, String name, String lastname, Integer dni, String position, CompanyDTO company) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
        this.position = position;
        this.company = company;
    }

    public RepresentantDTO(String name, String lastname, Integer dni, String position, CompanyDTO company) {
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
        this.position = position;
        this.company = company;
    }
}
