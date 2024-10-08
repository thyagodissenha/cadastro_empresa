package br.com.dissenha.thyago.cadastro.infra.exception;

public class ValidacaoException extends RuntimeException {
    public ValidacaoException(String message) {
        super(message);
    }
}
