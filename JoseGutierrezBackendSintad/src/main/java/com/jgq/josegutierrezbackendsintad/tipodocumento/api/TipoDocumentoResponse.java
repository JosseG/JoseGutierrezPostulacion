package com.jgq.josegutierrezbackendsintad.tipodocumento.api;

import com.jgq.josegutierrezbackendsintad.tipodocumento.model.dto.TipoDocumentoDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TipoDocumentoResponse {

    private int code;
    private List<TipoDocumentoDto> content;
}
