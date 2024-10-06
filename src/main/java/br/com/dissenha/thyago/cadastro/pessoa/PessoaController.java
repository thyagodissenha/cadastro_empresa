package br.com.dissenha.thyago.cadastro.pessoa;

import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalharPessoa> buscarPessoa(@PathVariable Long id) {
        return null;
    }

    @GetMapping
    public ResponseEntity<List<DadosListarPessoa>> listarPessoa(){
        return null;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DadosCadastrarPessoa> cadastrarPessoa(@RequestBody Pessoa pessoa){
        return null;
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosAtualizarPessoa> atualizarPessoa(@RequestBody Pessoa pessoa){
        return null;
    }
}
