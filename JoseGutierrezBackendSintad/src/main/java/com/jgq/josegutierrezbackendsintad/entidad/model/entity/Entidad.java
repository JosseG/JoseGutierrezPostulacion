package com.jgq.josegutierrezbackendsintad.entidad.model.entity;

import com.jgq.josegutierrezbackendsintad.tipocontribuyente.model.entity.TipoContribuyente;
import com.jgq.josegutierrezbackendsintad.tipodocumento.model.entity.TipoDocumento;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_entidad")
public class Entidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entidad")
    private int id;

    @Column(name = "nro_documento",unique = true)
    @Pattern(regexp="[\\d]{8,20}")
    private String nroDocumento;

    @Column(name = "razon_social")
    @NotBlank
    private String razonSocial;

    @Column(name = "nombre_comercial")
    @NotBlank
    private String nombreComercial;

    @Column(name = "direccion")
    @NotBlank
    private String direccion;

    @Column(name = "telefono")
    @Pattern(regexp="[\\d]{9}")
    private String telefono;

    @Column(name = "estado")
    private boolean estado;


    @ManyToOne
    @JoinColumn(name = "id_tipo_documento")
    private TipoDocumento tipoDocumento;

    @ManyToOne
    @JoinColumn(name = "id_tipo_contribuyente")
    private TipoContribuyente tipoContribuyente;

}
