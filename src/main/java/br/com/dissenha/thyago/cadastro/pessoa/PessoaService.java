package br.com.dissenha.thyago.cadastro.pessoa;

import br.com.dissenha.thyago.cadastro.infra.exception.ValidacaoException;
import br.com.dissenha.thyago.cadastro.util.Util;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public DadosDetalharPessoa buscarPessoa(UUID id) {
        return pessoaRepository.findById(id)
                .map(DadosDetalharPessoa::new)
                .orElseThrow(() -> new ValidacaoException("Pessoa Não encontrada!"));
    }

    public Page<DadosListarPessoa> listarPessoas(Pageable paginacao) {
        return pessoaRepository.findAll(paginacao).map(DadosListarPessoa::new);
    }

    @Transactional
    public DadosDetalharPessoa cadastrarPessoa(DadosCadastrarPessoa dadosCadastrarPessoa) {
        Pessoa pessoa = new Pessoa(dadosCadastrarPessoa);
        return new DadosDetalharPessoa(pessoaRepository.save(pessoa));
    }

    @Transactional
    public DadosDetalharPessoa atualizarPessoa(DadosAtualizarPessoa dadosAtualizarPessoa) {
        if(!pessoaRepository.existsById(dadosAtualizarPessoa.id()))
            throw new ValidacaoException("Pessoa não encontrado!");
        Pessoa pessoa = pessoaRepository.getReferenceById(dadosAtualizarPessoa.id());
        Util.copiarPropriedadesNaoNulas(dadosAtualizarPessoa, pessoa);
        return new DadosDetalharPessoa(pessoa);
    }
}
