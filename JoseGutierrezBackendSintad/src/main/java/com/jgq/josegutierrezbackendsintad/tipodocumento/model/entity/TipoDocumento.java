package com.jgq.josegutierrezbackendsintad.tipodocumento.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jgq.josegutierrezbackendsintad.entidad.model.entity.Entidad;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_tipo_documento")
public class TipoDocumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_documento")
    private int id;

    @GenericGenerator(name="uuid",type = org.hibernate.id.uuid.UuidGenerator.class)
    @Column(name = "codigo",unique = true)
    private String codigo;

    @Column(name = "nombre",unique = true)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado")
    private boolean estado;


    @OneToMany(mappedBy = "tipoDocumento")
    @JsonIgnore
    private Set<Entidad> entidades;
}
