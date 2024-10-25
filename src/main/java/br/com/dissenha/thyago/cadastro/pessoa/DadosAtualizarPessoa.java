package br.com.dissenha.thyago.cadastro.pessoa;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record DadosAtualizarPessoa(
        UUID id,
        @NotBlank
        String nome,
        String nomeSocial,
        @NotBlank
        @Email
        String email,
        @NotNull
        LocalDate dataNascimento
) {
}
