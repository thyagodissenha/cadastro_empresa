package br.com.dissenha.thyago.register.register;

import br.com.dissenha.thyago.register.person.Person;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@EqualsAndHashCode(of = "id")
public class Register implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    private String email;
    private String doingBusinessAs;
    private String lastnameSocial;
    private Boolean company;

    @OneToOne
    @JoinColumn(name = "person_id")
    Person person;

}
