package ar.com.ada.cursarproject.cursarproject.model.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Year;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @Column(nullable = false)
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

    public Company setName(String name) {
        this.name = name;
        return this;
    }
    public Company setCuil(Integer cuil) {
        this.cuil = cuil;
        return this;
    }
    public Company setType(String type) {
        this.type = type;
        return this;
    }
    public Company setAddress(String address) {
        this.address = address;
        return this;
    }
    public Company setCategory(String category) {
        this.category = category;
        return this;
    }
    public Company setFoundationYear(Year foundationYear) {
        this.foundationYear = foundationYear;
        return this;
    }
    public Company setContactNumber(Integer contactNumber) {
        this.contactNumber = contactNumber;
        return this;
    }
    public Company setCompanyCategory(CompanyCategory companyCategory) {
        this.companyCategory = companyCategory;
        return this;
    }
}