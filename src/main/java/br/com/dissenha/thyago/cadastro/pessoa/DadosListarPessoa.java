package br.com.dissenha.thyago.cadastro.pessoa;

public record DadosListarPessoa(
        Long id,
        String nome
) {
    public DadosListarPessoa(Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getNome());
    }
}
