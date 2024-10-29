package br.com.dissenha.thyago.register.register;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RegisterRepository extends JpaRepository<Register, UUID> {
}
