package br.com.dissenha.thyago.cadastro.cadastro;

import org.springframework.stereotype.Service;

@Service
public class CadastroService {

    private final CadastroRepository cadastroRepositori;

    public CadastroService(CadastroRepository cadastroRepository){
        this.cadastroRepositori = cadastroRepository;
    }
}
