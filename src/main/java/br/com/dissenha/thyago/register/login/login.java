package br.com.dissenha.thyago.register.login;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import br.com.dissenha.thyago.register.user.DataAuthentication;
import br.com.dissenha.thyago.register.user.User;
import br.com.dissenha.thyago.register.infra.security.DataTokenJWT;
import br.com.dissenha.thyago.register.infra.security.TokenService;

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
    public ResponseEntity<DataTokenJWT> efetuarLogin(@RequestBody @Valid DataAuthentication data) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(data.login(), data.password());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        String tokenJTW = tokenService.getToken((User) authentication.getPrincipal());
        return ResponseEntity.ok(new DataTokenJWT(tokenJTW));
    }
}
