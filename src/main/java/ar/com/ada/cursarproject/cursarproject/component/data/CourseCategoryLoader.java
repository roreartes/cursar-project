package ar.com.ada.cursarproject.cursarproject.component.data;

import ar.com.ada.cursarproject.cursarproject.model.entity.CourseCategory;
import ar.com.ada.cursarproject.cursarproject.model.repository.CourseCategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@Component
public class CourseCategoryLoader implements ApplicationRunner {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyCategoryLoader.class);
    @Autowired
    @Qualifier("courseCategoryRepository")
    private CourseCategoryRepository courseCategoryRepository;

    @Value("${spring.application.env}")
    private String appEnv;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOGGER.info("Environment: " + appEnv);

        if (appEnv.equals("dev") || appEnv.equals("qa")) {


            LOGGER.info("Loading CourseCategories initial data...");

            List<CourseCategory> companyCategoryList = Arrays.asList(
                    new CourseCategory("Bootcamp- Intensivo"),
                    new CourseCategory("Tecnicatura y Licenciatura"),
                    new CourseCategory("Seminario-Practicas"),
                    new CourseCategory("Taller")
            );

            companyCategoryList.forEach(companyCategory -> courseCategoryRepository.save(companyCategory));
        }
    }

}

