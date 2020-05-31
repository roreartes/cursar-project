package ar.com.ada.cursarproject.cursarproject.component.data;


import ar.com.ada.cursAR.cursAR.exception.ApiEntityError;
import ar.com.ada.cursAR.cursAR.exception.BusinessLogicException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component("businessLogicExceptionComponent")
public class BusinessLogicExceptionComponent {

    public void throwExceptionEntityNotFound(String entityName, Long id){
        ApiEntityError apiEntityError = new ApiEntityError(
                entityName,
                "NotFound",
                "The person with id '" + id + "' does not exist"
        );
        throw new BusinessLogicException(
                entityName + " does not exist",
                HttpStatus.NOT_FOUND,
                apiEntityError
        );
    }
}
