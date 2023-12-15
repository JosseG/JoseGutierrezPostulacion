package com.jgq.josegutierrezbackendsintad.authentication.repository;

import com.jgq.josegutierrezbackendsintad.authentication.model.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token,Integer> {

    @Query(value = """
      select t from Token t inner join Usuario u
      on t.usuario.id = u.id
      where u.id = :id and (t.expirado = false or t.revocado = false)\s
      """)
    List<Token> findAllValidTokenByUser(int id);
    Optional<Token> findByToken(String token);
}
