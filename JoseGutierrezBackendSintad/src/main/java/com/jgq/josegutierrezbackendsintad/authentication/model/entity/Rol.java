package com.jgq.josegutierrezbackendsintad.authentication.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private int id;

    @Column(name = "nombre_rol")
    @NotBlank
    private String nombre;

    @Column(name = "estado")
    private boolean estado;

    @OneToMany(mappedBy = "rol")
    @JsonIgnore
    private Set<Usuario> usuarios;


}
