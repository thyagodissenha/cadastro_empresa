package br.com.dissenha.thyago.register.person;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record DataUpdatePerson(
        @NotNull
        UUID id,
        String name,
        String nameSocial,
        @Email
        String email,
        LocalDate birthday
) {
}
