package br.com.dissenha.thyago.cadastro.cadastro;

import br.com.dissenha.thyago.cadastro.pessoa.Pessoa;
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
public class Cadastro implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    private String email;
    private String nomeFantasia;
    private String sobrenomeSocial;
    private Boolean empresa;

    @OneToOne
    @JoinColumn(name = "pessoa_id")
    Pessoa pessoa;

}
