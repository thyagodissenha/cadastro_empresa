package br.com.dissenha.thyago.cadastro.infra.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<DadosExceptionDetalhamento> tratorErroGenerico(Exception ex){
        return ResponseEntity.badRequest().body(new DadosExceptionDetalhamento(ex.getMessage()));
    }
}
