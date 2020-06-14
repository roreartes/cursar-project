package ar.com.ada.cursarproject.cursarproject.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class CoursesDTO implements Serializable {

    private Long id;

    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "description is required")
    private String description;

    @NotBlank(message = "modality is required")
    private String modality;

    @NotNull(message = "cost is required")
    private Integer cost;

    @Pattern(regexp = "^(0|[1-9][0-9]*)$")
    @NotNull(message = "courseHours is required")
    private Integer courseHours;

   // @Pattern(regexp = "^(0|[1-9][0-9]*)$")
    @NotNull(message = "quota is required")
    private Integer quota;

    @Pattern(regexp = "^(0|[1-9][0-9]*)$")
    @NotNull(message = "scholarship is required")
    private Integer scholarship;

    @NotNull(message = "companyId is required")
    private Long companyId;

    @Valid
    @NotNull(message = "courseCategory is required")
    private CourseCategoryDTO courseCategory;

    @JsonIgnoreProperties(value = "courses")
    private CompanyDTO company;




}
