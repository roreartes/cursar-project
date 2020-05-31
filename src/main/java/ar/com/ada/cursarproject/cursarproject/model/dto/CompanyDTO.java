package ar.com.ada.cursarproject.cursarproject.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@JsonPropertyOrder({"id", "name", "cuil", "type", "address", "category", "foundationYear", "contactNumber", "categoriesCompanyDTO", "representantDTO"})
public class CompanyDTO implements Serializable {

    private Long id;
    @NotBlank(message = "name is required")
    private String name;
    @NotBlank(message = "cuil is required")
    @Pattern(regexp = "")
    private Integer cuil;
    @NotBlank(message = "type is required")
    private String type;

    @Pattern(regexp = "^[0-9a-zA-ZáéíóúÁÉÍÓÚÜüñÑ\\s]*$", message = "address contains not allowed characters")
    @NotBlank(message = "address is required")
    private String address;

    @NotBlank(message = "category is required")
    private String category;

    @JsonFormat(pattern = "yyyy")
    @NotNull(message = "foundation year is required")
    @PastOrPresent(message = "the year must be past or present")
    private LocalDate foundationYear;

    @Pattern(regexp = "^(0|[1-9][0-9]*)$")
    @NotNull(message = "contactNumber is required")
    private Integer contactNumber;
    @NotBlank(message = "categories Company is required")
    private CompanyCategoryDTO categoriesCompanyDTO;
    @NotBlank(message = "representant is required")
    private RepresentantDTO representant;

    private Set<CoursesDTO> courses;


    public CompanyDTO(Long id,  String name, Integer cuil, String type,  String address, String category, LocalDate foundationYear, Integer contactNumber,  CompanyCategoryDTO categoriesCompanyDTO, RepresentantDTO representant, Set<CoursesDTO> courses) {
        this.id = id;
        this.name = name;
        this.cuil = cuil;
        this.type = type;
        this.address = address;
        this.category = category;
        this.foundationYear = foundationYear;
        this.contactNumber = contactNumber;
        this.categoriesCompanyDTO = categoriesCompanyDTO;
        this.representant = representant;
        this.courses = courses;
    }

    public CompanyDTO(String name, Integer cuil, String type, String address, String category, LocalDate foundationYear,
                      Integer contactNumber, CompanyCategoryDTO categoriesCompanyDTO, RepresentantDTO representantDTO, Set<CoursesDTO> courses) {
        this.name = name;
        this.cuil = cuil;
        this.type = type;
        this.address = address;
        this.category = category;
        this.foundationYear = foundationYear;
        this.contactNumber = contactNumber;
        this.categoriesCompanyDTO = categoriesCompanyDTO;
        this.representant = representant;
        this.courses = courses;

    }
}
