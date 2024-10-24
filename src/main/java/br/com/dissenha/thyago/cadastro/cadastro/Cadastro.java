package br.com.dissenha.thyago.cadastro.cadastro;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@EqualsAndHashCode(of = "id")
public class Cadastro {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    private String email;
    private String nomeFantasia;
    private String sobrenomeSocial;
    private Boolean empresa;

}
