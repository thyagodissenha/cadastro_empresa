package br.com.dissenha.thyago.cadastro.infra.exception;

import jakarta.servlet.ServletException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<DadosExceptionDetalhamento> tratorErroGenerico(Exception ex){
        return ResponseEntity.badRequest().body(new DadosExceptionDetalhamento(ex.toString()));
    }

    @ExceptionHandler(ServletException.class)
    public void tratorErroGenerico(ServletException ex){
        ex.printStackTrace();
    }
}
