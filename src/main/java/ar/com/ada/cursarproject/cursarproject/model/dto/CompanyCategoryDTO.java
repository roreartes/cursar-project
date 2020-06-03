package ar.com.ada.cursarproject.cursarproject.model.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class CompanyCategoryDTO implements Serializable {
    @NotNull(message = "id is required")
    private Long id;


    private String name;
}



