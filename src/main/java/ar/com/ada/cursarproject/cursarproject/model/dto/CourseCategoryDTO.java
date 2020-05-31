package ar.com.ada.cursarproject.cursarproject.model.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class CourseCategoryDTO implements Serializable {

    private Long id;
    @NotBlank(message = "name is required")

    private String name;

    public CourseCategoryDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CourseCategoryDTO(String name) {
        this.name = name;
    }
}
