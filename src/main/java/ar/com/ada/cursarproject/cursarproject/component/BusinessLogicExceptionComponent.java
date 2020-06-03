package ar.com.ada.cursarproject.cursarproject.component;


import ar.com.ada.cursarproject.cursarproject.exception.ApiEntityError;
import ar.com.ada.cursarproject.cursarproject.exception.BusinessLogicException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component("businessLogicExceptionComponent")
public class BusinessLogicExceptionComponent {
    public RuntimeException throwExceptionEntityNotFound(String entityName, Long id){
        ApiEntityError apiEntityError = new ApiEntityError(
                entityName,
                "NotFound",
                "The person with id '" + id + "' does not exist"
        );
        return new BusinessLogicException(
                entityName + " does not exist",
                HttpStatus.NOT_FOUND,
                apiEntityError
        );
    }
}
