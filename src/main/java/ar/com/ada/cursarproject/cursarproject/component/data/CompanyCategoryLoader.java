package ar.com.ada.cursarproject.cursarproject.component.data;

import ar.com.ada.cursarproject.cursarproject.model.entity.CompanyCategory;
import ar.com.ada.cursarproject.cursarproject.model.repository.CategoryCompanyRepository;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
/*

@Component
public class CompanyCategoryLoader implements ApplicationRunner {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(CompanyCategoryLoader.class);

    @Autowired
    @Qualifier("categoryCompanyRepository")
    private CategoryCompanyRepository categoryCompanyRepository;

    @Value("${spring.application.env}")
    private String appEnv;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOGGER.info("Environment: " + appEnv);

        if (appEnv.equals("dev") || appEnv.equals("qa")) {


            LOGGER.info("Loading CompanyCategories initial data...");

            List<CompanyCategory> companyCategoryList = Arrays.asList(
                    new CompanyCategory("Marketing"),
                    new CompanyCategory("Servicios"),
                    new CompanyCategory("Tecnología"),
                    new CompanyCategory("Comercio")
            );

            companyCategoryList.forEach(companyCategory -> categoryCompanyRepository.save(companyCategory));
        }
    }
}
*/
