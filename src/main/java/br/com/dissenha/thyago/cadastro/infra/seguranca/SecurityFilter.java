package br.com.dissenha.thyago.cadastro.infra.seguranca;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import br.com.dissenha.thyago.cadastro.usuario.UsuarioService;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private final TokenService tokenService;
    private final UsuarioService usuarioService;

    public SecurityFilter(TokenService tokenService, UsuarioService usuarioService) {
        this.tokenService = tokenService;
        this.usuarioService = usuarioService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String tokenJWT = recuperarToken(request);
        if(tokenJWT != null) {
            String subject = tokenService.getSubject(tokenJWT);
            UserDetails usuario = usuarioService.buscarUsuarioPorLogin(subject);

            Authentication authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    private String recuperarToken(HttpServletRequest request) {
        String autorizationHeader = request.getHeader("Authorization");
        if(autorizationHeader != null && autorizationHeader.startsWith("Bearer "))
            return autorizationHeader.replace("Bearer ", "");
        return null;
    }
}
