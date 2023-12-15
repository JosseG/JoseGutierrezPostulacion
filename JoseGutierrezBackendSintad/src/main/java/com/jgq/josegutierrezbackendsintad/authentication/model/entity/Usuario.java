package com.jgq.josegutierrezbackendsintad.authentication.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int id;

    @Column(name = "username", unique = true)
    @NotBlank
    private String username;

    @Column(name = "password")
    @NotBlank
    private String password;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Token> tokens;

    @Column(name = "estado")
    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_rol",updatable = false,nullable = false)
    private Rol rol;

}
