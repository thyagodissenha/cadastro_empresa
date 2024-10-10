package br.com.dissenha.thyago.cadastro.usuario;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UserDetails buscarUsuarioPorLogin(String login) throws UsernameNotFoundException {
        return usuarioRepository.findByLogin(login);
    }
}
