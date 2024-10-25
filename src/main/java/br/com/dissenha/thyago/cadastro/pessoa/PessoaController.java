package br.com.dissenha.thyago.cadastro.pessoa;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalharPessoa> buscarPessoa(@PathVariable UUID id) {
        return ResponseEntity.ok(pessoaService.buscarPessoa(id));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListarPessoa>> listarPessoa(
            @PageableDefault(size = 20) Pageable paginacao
    ){
        return ResponseEntity.ok(pessoaService.listarPessoas(paginacao));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalharPessoa> cadastrarPessoa(@RequestBody @Valid DadosCadastrarPessoa dados, UriComponentsBuilder uriBuilder) {
        DadosDetalharPessoa dadosDetalharPessoa = pessoaService.cadastrarPessoa(dados);
        URI uri = uriBuilder.path("pessoa/{id}").buildAndExpand(dadosDetalharPessoa.id()).toUri();
        return ResponseEntity.created(uri).body(dadosDetalharPessoa);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalharPessoa> atualizarPessoa(@RequestBody @Valid DadosAtualizarPessoa dados){
        return ResponseEntity.ok(pessoaService.atualizarPessoa(dados));
    }
}
