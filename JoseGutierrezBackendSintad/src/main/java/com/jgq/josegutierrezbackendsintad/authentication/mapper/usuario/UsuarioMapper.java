package com.jgq.josegutierrezbackendsintad.authentication.mapper.usuario;

import com.jgq.josegutierrezbackendsintad.authentication.model.dto.RolDto;
import com.jgq.josegutierrezbackendsintad.authentication.model.dto.UsuarioDto;
import com.jgq.josegutierrezbackendsintad.authentication.model.dto.UsuarioInsertDto;
import com.jgq.josegutierrezbackendsintad.authentication.model.entity.Usuario;

public class UsuarioMapper {

    public static Usuario mapToEntity(UsuarioDto usuarioDto){

        Usuario usuario = new Usuario();
        usuario.setUsername(usuarioDto.getUsername());
        usuario.setPassword(usuarioDto.getPassword());
        usuario.setEstado(usuarioDto.isEstado());
        return usuario;
    }

    public static UsuarioDto mapToDto(Usuario usuario){
        UsuarioDto usuarioDto = new UsuarioDto();

        usuarioDto.setId(usuario.getId());
        usuarioDto.setUsername(usuario.getUsername());
        usuarioDto.setPassword(usuario.getPassword());
        usuarioDto.setEstado(usuario.isEstado());
        return usuarioDto;
    }

    public static UsuarioDto mapFromCommandInsertToDto(UsuarioInsertDto usuarioInsertDto){

        RolDto rolDto = new RolDto();
        rolDto.setId(usuarioInsertDto.getIdRol());

        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setUsername(usuarioInsertDto.getUsername());
        usuarioDto.setPassword(usuarioInsertDto.getPassword());
        usuarioDto.setEstado(true);
        usuarioDto.setRol(rolDto);
        return usuarioDto;
    }
}
