package ar.com.ada.cursarproject.cursarproject.model.repository;

import ar.com.ada.cursarproject.cursarproject.model.entity.Company;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;
import java.time.Year;
import java.util.List;

@SpringBootTest
class CompanyRepositoryTest {

    @Autowired @Qualifier("companyRepository")
    private CompanyRepository companyRepository;

    @Test @Order(0)
    public void whenSaveThenReturnCompanyId(){


        Company company = new Company()
                .setName("IBM")
                .setCuil(233484736)
                .setType("SA")
                .setAddress("Cabildo 80")
                .setCategory("Tecnologia")
                .setFoundationYear(Year.of(1993))
                .setContactNumber(1145406678);

        Company saved = companyRepository.save(company);

        assertNotNull(saved.getId());
    }



        @Test @Order(1)
        public void returnCompanyListWhenFindAll(){
            List<Company> allCompanies = companyRepository.findAll();

            assertThat(allCompanies).hasSizeGreaterThan(0);

        }
    }



