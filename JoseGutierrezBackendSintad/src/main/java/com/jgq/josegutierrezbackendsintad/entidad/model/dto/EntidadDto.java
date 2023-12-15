package com.jgq.josegutierrezbackendsintad.entidad.model.dto;

import com.jgq.josegutierrezbackendsintad.common.Estado;
import com.jgq.josegutierrezbackendsintad.tipocontribuyente.model.dto.TipoContribuyenteDto;
import com.jgq.josegutierrezbackendsintad.tipodocumento.model.dto.TipoDocumentoDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class EntidadDto {
    private int id;
    private String nroDocumento;
    private String razonSocial;
    private String nombreComercial;
    private String direccion;
    private String telefono;
    private boolean estado;
    private TipoDocumentoDto tipoDocumento;
    private TipoContribuyenteDto tipoContribuyente;

    public void declararDisponibilidad(Estado estadoD){
        setEstado(Objects.requireNonNull(estadoD) == Estado.ACTIVO);
    }

}
