package ar.com.ada.cursarproject.cursarproject.model.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Year;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 11)
    private Integer cuil;

    @Column(nullable = false, length = 50)
    private String type;

    @Column(nullable = false, length = 100)
    private String address;

    @Column(nullable = false, length = 60)
    private String category;

    @Column(nullable = false, columnDefinition = "YEAR")
    private Year foundationYear;

    @Column(nullable = false, length = 20)
    private Integer contactNumber;


    @ManyToOne
    @JoinColumn( name = "CompanyCategory_id")
    private CompanyCategory companyCategory;


    @OneToOne(mappedBy = "company", cascade = CascadeType.ALL)
    private Representant representant;

    @OneToMany(mappedBy = "company")
    private Set<Courses> courses;
}