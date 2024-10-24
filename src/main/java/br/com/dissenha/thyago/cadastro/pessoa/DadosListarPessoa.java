package br.com.dissenha.thyago.cadastro.pessoa;

import java.util.UUID;

public record DadosListarPessoa(
        UUID id,
        String nome
) {
    public DadosListarPessoa(Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getNome());
    }
}
