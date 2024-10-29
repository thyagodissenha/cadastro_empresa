package br.com.dissenha.thyago.register.person;

import br.com.dissenha.thyago.register.register.Register;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@EqualsAndHashCode(of = "id")
public class Person implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    private String cpfCnpj;
    private String name;
    private String nameSocial;
    private String email;
    private LocalDate birthday;
    private String token;
    @OneToOne
    @JoinColumn(name = "id")
    Register register;

    public Person(DataAddPerson dataAddPerson) {
        this.cpfCnpj = dataAddPerson.cpfCnpj();
        this.name = dataAddPerson.name();
        this.nameSocial = dataAddPerson.nameSocial();
        this.email = dataAddPerson.email();
        this.birthday = dataAddPerson.birthday();
    }

}
