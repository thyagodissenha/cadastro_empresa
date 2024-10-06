package br.com.dissenha.thyago.cadastro.pessoa;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public DadosDetalharPessoa buscarPessoa(Long id) {
        return null;
    }

    public List<DadosListarPessoa> listarPessoas() {
        return null;
    }

    public DadosDetalharPessoa cadastrarPessoa(DadosCadastrarPessoa dadosCadastrarPessoa) {
        return null;
    }

    public DadosDetalharPessoa atualizarPessoa(DadosAtualizarPessoa dadosAtualizarPessoa) {
        return null;
    }
}
