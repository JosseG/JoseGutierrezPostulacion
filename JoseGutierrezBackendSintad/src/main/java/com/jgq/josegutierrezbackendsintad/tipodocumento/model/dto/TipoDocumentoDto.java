package com.jgq.josegutierrezbackendsintad.tipodocumento.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoDocumentoDto {

    private int id;

    private String codigo;

    private String nombre;

    private String descripcion;

    private boolean estado;

}
