package br.com.dissenha.thyago.cadastro.pessoa;

import java.time.LocalDate;
import java.util.UUID;

public record DadosDetalharPessoa(
        UUID id,
        String nome,
        String nomeSocial,
        String cpfCnpj,
        String email,
        LocalDate dataNascimento
) {
    public DadosDetalharPessoa(Pessoa pessoa){
        this(pessoa.getId(), pessoa.getNome(), pessoa.getNomeSocial(), pessoa.getCpfCnpj(),
                pessoa.getEmail(), pessoa.getAniversario());
    }
}
