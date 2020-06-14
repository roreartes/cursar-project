package ar.com.ada.cursarproject.cursarproject.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.Year;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@JsonPropertyOrder({"id", "name", "cuil", "type", "address", "category", "foundationYear", "contactNumber", "categoriesCompany", "representantDTO"})
public class CompanyDTO implements Serializable {

    private Long id;

    @NotBlank(message = "name is required")
    private String name;

    @NotNull(message = "cuil is required")
//    @Pattern(regexp = "^(0|[1-9][0-9]*)$")
    private Long cuil;

    @NotBlank(message = "type is required")
    private String type;

    @Pattern(regexp = "^[0-9a-zA-ZáéíóúÁÉÍÓÚÜüñÑ\\s]*$", message = "address contains not allowed characters")
    @NotBlank(message = "address is required")
    private String address;

    @NotBlank(message = "category is required")
    private String category;

    @NotNull(message = "fundationYear is required")
    @Past(message = "fundationYear must be past date")
    private Year foundationYear;

    //    @Pattern(regexp = "^(0|[1-9][0-9]*)$")
    @NotNull(message = "contactNumber is required")
    private Integer contactNumber;

    @Valid
    @NotNull(message = "categories Company is required")
    private CompanyCategoryDTO companyCategory  ;

    private RepresentantDTO representant;

    private Set<CoursesDTO> courses;
}

/*
{
    "name": "comp 1",
    "cuil": 10203004005,
    "type": "SA",
    "address": "florida 200",
    "category": "it",
    "foundationYear": 2010,
    "contactNumber": 12345678,
    "companyCategory": {
        "id": 1
    }
}
*/
