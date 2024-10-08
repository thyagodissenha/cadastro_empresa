package br.com.dissenha.thyago.cadastro.pessoa;

import java.time.LocalDate;

public record DadosAtualizarPessoa(
        Long id,
        String nome,
        String nomeSocial,
        String email,
        LocalDate dataNascimento
) {
}
