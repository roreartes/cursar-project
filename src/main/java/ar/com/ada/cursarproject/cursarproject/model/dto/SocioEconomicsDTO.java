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
public class SocioEconomicsDTO implements Serializable {

    private Long id;
    @NotBlank(message = "study is required")
    private Boolean study;

    @NotBlank(message = "hasJob is required")
    private Boolean hasJob;

    @NotBlank(message = "haveIncome is required")
    private Boolean haveIncome;
    @NotBlank(message = "familyInCharge is required")
    private Boolean familyInCharge;

    @NotBlank(message = "howMany is required")
    @Pattern(regexp = "^(0|[1-9][0-9]*)$")
    private Boolean howMany;

    @NotBlank(message = "howMany is required")
    private ParticipantDTO participant;

    @NotNull(message = "participantId is required")
    private Long participantId;


    public SocioEconomicsDTO(Long id, Boolean study, Boolean hasJob, Boolean haveIncome,
                             Boolean familyInCharge, Boolean howMany, ParticipantDTO participant) {
        this.id = id;
        this.study = study;
        this.hasJob = hasJob;
        this.haveIncome = haveIncome;
        this.familyInCharge = familyInCharge;
        this.howMany = howMany;
        this.participant = participant;
    }

    public SocioEconomicsDTO(Boolean study, Boolean hasJob, Boolean haveIncome,
                             Boolean familyInCharge, Boolean howMany,
                             ParticipantDTO participant) {
        this.study = study;
        this.hasJob = hasJob;
        this.haveIncome = haveIncome;
        this.familyInCharge = familyInCharge;
        this.howMany = howMany;
        this.participant = participant;
    }
}
