package br.com.dissenha.thyago.register.person;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DataAddPerson(
        @NotBlank
        String name,
        String nameSocial,
        @NotBlank
        String cpfCnpj,
        @NotBlank
        @Email
        String email,
        @NotNull
        LocalDate birthday
) {
}
