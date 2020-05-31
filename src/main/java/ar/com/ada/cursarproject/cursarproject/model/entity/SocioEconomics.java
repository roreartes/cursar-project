package ar.com.ada.cursarproject.cursarproject.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "SocioEconomics")

public class SocioEconomics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 3)
   private Boolean study;

    @Column(nullable = false, length = 3)
   private Boolean hasJob;

    @Column(nullable = false, length = 3)
    private Boolean haveIncome;

    @Column(nullable = false, length = 3)
  private Boolean familyInCharge;

    @Column(nullable = false, length = 3)
   private Boolean howMany;

    @OneToOne
    @JoinColumn(name = "Participan_id", updatable = false, nullable = false)
    private Participant participant;


}
