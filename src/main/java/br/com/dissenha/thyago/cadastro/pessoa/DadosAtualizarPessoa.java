package br.com.dissenha.thyago.cadastro.pessoa;

import java.time.LocalDate;
import java.util.UUID;

public record DadosAtualizarPessoa(
        UUID id,
        String nome,
        String nomeSocial,
        String email,
        LocalDate dataNascimento
) {
}
