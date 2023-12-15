package com.jgq.josegutierrezbackendsintad.entidad.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntidadInsertDto {
    private String nroDocumento;
    private String razonSocial;
    private String nombreComercial;
    private String direccion;
    private String telefono;
    private int idTipoDocumento;
    private int idTipoContribuyente;
}
