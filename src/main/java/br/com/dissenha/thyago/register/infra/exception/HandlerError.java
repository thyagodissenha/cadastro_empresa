package br.com.dissenha.thyago.register.infra.exception;

import jakarta.servlet.ServletException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerError {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<DataExceptionDetail> handlerGenericError(Exception ex){
        return ResponseEntity.badRequest().body(new DataExceptionDetail(ex.toString()));
    }

    @ExceptionHandler(ServletException.class)
    public void handlerGenericError(ServletException ex){
        ex.printStackTrace();
    }
}
