package com.jgq.josegutierrezbackendsintad.tipocontribuyente.api;

import com.jgq.josegutierrezbackendsintad.tipocontribuyente.model.dto.TipoContribuyenteDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TipoContribuyenteResponse {
    private int code;
    private List<TipoContribuyenteDto> content;
}
