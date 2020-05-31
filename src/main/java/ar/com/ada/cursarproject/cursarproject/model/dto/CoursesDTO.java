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

    @Pattern(regexp = "^(0|[1-9][0-9]*)$")
    @NotNull(message = "quota is required")
    private Integer quota;

    @Pattern(regexp = "^(0|[1-9][0-9]*)$")
    @NotNull(message = "scholarship is required")
    private Integer scholarship;

    @NotBlank(message = "company is required")
    private CompanyDTO company;

    @NotBlank(message = "courseCategory is required")
    private CourseCategoryDTO courseCategory;

    public CoursesDTO(Long id, String name, String description,  String modality, Integer cost,
                      Integer courseHours, Integer quota, Integer scholarship, CompanyDTO company,
                      CourseCategoryDTO courseCategory) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.modality = modality;
        this.cost = cost;
        this.courseHours = courseHours;
        this.quota = quota;
        this.scholarship = scholarship;
        this.company = company;
        this.courseCategory = courseCategory;
    }

    public CoursesDTO(String name, String description, String modality, Integer cost, Integer courseHours,
                      Integer quota, Integer scholarship,CompanyDTO company, CourseCategoryDTO courseCategory) {
        this.name = name;
        this.description = description;
        this.modality = modality;
        this.cost = cost;
        this.courseHours = courseHours;
        this.quota = quota;
        this.scholarship = scholarship;
        this.company = company;
        this.courseCategory = courseCategory;
    }
}
