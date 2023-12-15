package com.jgq.josegutierrezbackendsintad.authentication.service;

import com.jgq.josegutierrezbackendsintad.authentication.model.dto.LoginDto;
import com.jgq.josegutierrezbackendsintad.authentication.model.dto.UsuarioDto;

public interface AuthenticationService {

    String login(LoginDto loginDto);

    UsuarioDto register(UsuarioDto usuarioDto);
}
