package ar.com.ada.cursarproject.cursarproject.model.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class CompanyCategoryDTO implements Serializable {

    private Long id;

    @NotBlank(message = "name is required")
    private String name;

    public CompanyCategoryDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CompanyCategoryDTO(String name) {
        this.name = name;
    }
}

