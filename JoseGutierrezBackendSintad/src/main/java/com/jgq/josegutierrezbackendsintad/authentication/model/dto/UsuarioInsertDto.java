package com.jgq.josegutierrezbackendsintad.authentication.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioInsertDto {

    private String username;
    private String password;
    private int idRol;

}
