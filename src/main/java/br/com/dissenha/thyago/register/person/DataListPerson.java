package br.com.dissenha.thyago.register.person;

import java.util.UUID;

public record DataListPerson(
        UUID id,
        String name
) {
    public DataListPerson(Person person) {
        this(person.getId(), person.getName());
    }
}
