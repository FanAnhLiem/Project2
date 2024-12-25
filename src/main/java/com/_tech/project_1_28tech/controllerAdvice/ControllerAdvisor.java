package com._tech.project_1_28tech.controllerAdvice;

import com._tech.project_1_28tech.model.ErrorBE;
import com._tech.project_1_28tech.model.RequireException;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;
;
@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Object> handleArithmeticException(ArithmeticException ex,  WebRequest request) {
        ErrorBE errorBE = new ErrorBE();
        errorBE.setName(ex.getMessage());
        List<String> details = new ArrayList<>();
        details.add("sô nguyên ko chia được cho 0");
        errorBE.setDetails(details);

        return new ResponseEntity<>(errorBE, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RequireException.class)
    public ResponseEntity<Object> handleRequireException(RequireException ex,  WebRequest request) {
        ErrorBE errorBE = new ErrorBE();
        errorBE.setName(ex.getMessage());
        List<String> details = new ArrayList<>();
        details.add("data trống kiểm tra lại đi");
        errorBE.setDetails(details);

        return new ResponseEntity<>(errorBE, HttpStatus.BAD_GATEWAY);
    }
}
