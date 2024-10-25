package br.com.dissenha.thyago.cadastro.pessoa;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosCadastrarPessoa(
        @NotBlank
        String nome,
        String nomeSocial,
        @NotBlank
        String cpfCnpj,
        @NotBlank
        @Email
        String email,
        @NotNull
        LocalDate dataNascimento
) {
}
