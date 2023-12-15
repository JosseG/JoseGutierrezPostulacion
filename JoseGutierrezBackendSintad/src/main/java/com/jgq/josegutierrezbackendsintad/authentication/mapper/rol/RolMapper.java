package com.jgq.josegutierrezbackendsintad.authentication.mapper.rol;

import com.jgq.josegutierrezbackendsintad.authentication.model.dto.RolDto;
import com.jgq.josegutierrezbackendsintad.authentication.model.entity.Rol;

public class RolMapper {

    public static RolDto mapToDto(Rol rol){
        RolDto rolDto = new RolDto();
        rolDto.setId(rol.getId());
        rolDto.setNombre(rol.getNombre());
        rolDto.setEstado(rolDto.isEstado());

        return rolDto;
    }
}
