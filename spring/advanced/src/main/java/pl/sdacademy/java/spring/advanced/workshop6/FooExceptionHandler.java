package pl.sdacademy.java.spring.advanced.workshop6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class FooExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(FooExceptionHandler.class);

    @ExceptionHandler(FooException.class)
    @ResponseStatus(HttpStatus.PAYMENT_REQUIRED)
    public CustomErrorDto handle(FooException fooException) {
        logger.warn("Samodzielne logowanie błędu", fooException);

        final CustomErrorDto customErrorDto = new CustomErrorDto();
        customErrorDto.setMessage(fooException.getMessage());
        return customErrorDto;
    }
}
