package br.com.dissenha.thyago.cadastro.cadastro;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CadastroRepository extends JpaRepository<Cadastro, UUID> {
}
