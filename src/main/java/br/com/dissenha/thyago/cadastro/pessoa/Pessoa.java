package br.com.dissenha.thyago.cadastro.pessoa;

import br.com.dissenha.thyago.cadastro.cadastro.Cadastro;
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
public class Pessoa implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    private String cpfCnpj;
    private String nome;
    private String nomeSocial;
    private String email;
    private LocalDate aniversario;
    private String token;
    @OneToOne
    @JoinColumn(name = "id")
    Cadastro cadastro;

    public Pessoa(DadosCadastrarPessoa dadosCadastrarPessoa) {
        this.cpfCnpj = dadosCadastrarPessoa.cpfCnpj();
        this.nome = dadosCadastrarPessoa.nome();
        this.nomeSocial = dadosCadastrarPessoa.nomeSocial();
        this.email = dadosCadastrarPessoa.email();
        this.aniversario = dadosCadastrarPessoa.dataNascimento();
    }

}
