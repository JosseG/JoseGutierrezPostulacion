package com.jgq.josegutierrezbackendsintad.authentication.repository;

import com.jgq.josegutierrezbackendsintad.authentication.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    Optional<Usuario> findUsuarioByUsername(String username);
}
