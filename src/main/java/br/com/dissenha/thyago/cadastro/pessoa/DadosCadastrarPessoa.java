package br.com.dissenha.thyago.cadastro.pessoa;

import java.time.LocalDate;

public record DadosCadastrarPessoa(
        String nome,
        String nomeSocial,
        String cpfCnpj,
        String email,
        LocalDate dataNascimento
) {
}
