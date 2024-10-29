package br.com.dissenha.thyago.register.register;

import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    private final RegisterRepository registerRepository;

    public RegisterService(RegisterRepository registerRepository){
        this.registerRepository = registerRepository;
    }
}
