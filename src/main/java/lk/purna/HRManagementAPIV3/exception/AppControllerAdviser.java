package lk.purna.HRManagementAPIV3.exception;

import lk.purna.HRManagementAPIV3.controller.response.error_response.CustomErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppControllerAdviser {

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler({EmployeeNotFoundException.class})
    public CustomErrorResponse handleNFException(Exception exception){

        CustomErrorResponse customErrorResponse = new CustomErrorResponse();

        customErrorResponse.setMessage("Not Found Exception");

        return customErrorResponse;
    }
}
