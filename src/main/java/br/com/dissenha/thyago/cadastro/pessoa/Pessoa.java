package br.com.dissenha.thyago.cadastro.pessoa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@EqualsAndHashCode(of = "id")
public class Pessoa {

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

    public Pessoa(DadosCadastrarPessoa dadosCadastrarPessoa) {
        this.cpfCnpj = dadosCadastrarPessoa.cpfCnpj();
        this.nome = dadosCadastrarPessoa.nome();
        this.nomeSocial = dadosCadastrarPessoa.nomeSocial();
        this.email = dadosCadastrarPessoa.email();
        this.aniversario = dadosCadastrarPessoa.dataNascimento();
    }

}
