package ar.com.ada.cursarproject.cursarproject.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Representant")
public class Representant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String lastname;

@Column(nullable = false, length = 10)
    private Integer dni;

    @Column(nullable = false, length = 50)
    private String position;
//
    @OneToOne
    @JoinColumn(name = "Company_id", updatable = false, nullable = false)
    private Company company;

}
