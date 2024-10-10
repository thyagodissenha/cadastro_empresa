package br.com.dissenha.thyago.cadastro.login;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import br.com.dissenha.thyago.cadastro.usuario.DadosAutenticacao;
import br.com.dissenha.thyago.cadastro.usuario.Usuario;
import br.com.dissenha.thyago.cadastro.infra.seguranca.DadosTokenJWT;
import br.com.dissenha.thyago.cadastro.infra.seguranca.TokenService;

@RestController
@RequestMapping("/login")
public class login {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public login(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<DadosTokenJWT> efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        String tokenJTW = tokenService.getToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(tokenJTW));
    }
}
