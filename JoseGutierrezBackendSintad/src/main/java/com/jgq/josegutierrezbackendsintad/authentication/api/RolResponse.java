package com.jgq.josegutierrezbackendsintad.authentication.api;

import com.jgq.josegutierrezbackendsintad.authentication.model.dto.RolDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RolResponse {
    private int code;
    private List<RolDto> content;
}
