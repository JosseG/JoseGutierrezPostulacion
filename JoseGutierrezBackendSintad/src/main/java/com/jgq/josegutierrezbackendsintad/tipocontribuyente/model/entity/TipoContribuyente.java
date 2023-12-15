package com.jgq.josegutierrezbackendsintad.tipocontribuyente.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jgq.josegutierrezbackendsintad.entidad.model.entity.Entidad;
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
@Table(name = "tb_tipo_contribuyente")
public class TipoContribuyente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_contribuyente")
    private int id;

    @Column(name = "nombre",unique = true)
    @NotBlank
    private String nombre;

    @Column(name = "estado")
    private boolean estado;

    @OneToMany(mappedBy = "tipoContribuyente")
    @JsonIgnore
    private Set<Entidad> entidades;

}
