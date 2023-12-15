package com.jgq.josegutierrezbackendsintad.authentication.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDto {

    private int id;
    private String username;
    private String password;
    private boolean estado;
    private RolDto rol;
}
