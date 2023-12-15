package com.jgq.josegutierrezbackendsintad.entidad.api;

import com.jgq.josegutierrezbackendsintad.entidad.model.dto.EntidadDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EntidadResponse {

    private int code;
    private List<EntidadDto> content;
}
