package br.com.dissenha.thyago.register.person;

import java.time.LocalDate;
import java.util.UUID;

public record DataDetailPerson(
        UUID id,
        String name,
        String nameSocial,
        String cpfCnpj,
        String email,
        LocalDate birthday
) {
    public DataDetailPerson(Person person){
        this(person.getId(), person.getName(), person.getNameSocial(), person.getCpfCnpj(),
                person.getEmail(), person.getBirthday());
    }
}
