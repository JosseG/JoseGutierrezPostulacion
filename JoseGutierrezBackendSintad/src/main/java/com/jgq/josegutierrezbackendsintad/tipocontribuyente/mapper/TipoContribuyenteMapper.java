package com.jgq.josegutierrezbackendsintad.tipocontribuyente.mapper;

import com.jgq.josegutierrezbackendsintad.tipocontribuyente.model.dto.TipoContribuyenteDto;
import com.jgq.josegutierrezbackendsintad.tipocontribuyente.model.dto.TipoContribuyenteInsertDto;
import com.jgq.josegutierrezbackendsintad.tipocontribuyente.model.dto.TipoContribuyenteUpdateDto;
import com.jgq.josegutierrezbackendsintad.tipocontribuyente.model.entity.TipoContribuyente;

public class TipoContribuyenteMapper {

    public static TipoContribuyente mapToEntity(TipoContribuyenteDto tipoContribuyenteDto){

        TipoContribuyente tipoContribuyente = new TipoContribuyente();

        tipoContribuyente.setId(tipoContribuyenteDto.getId());
        tipoContribuyente.setNombre(tipoContribuyenteDto.getNombre());
        tipoContribuyente.setEstado(tipoContribuyenteDto.isEstado());

        return tipoContribuyente;

    }

    public static TipoContribuyenteDto mapToDto(TipoContribuyente tipoContribuyente){
        TipoContribuyenteDto tipoContribuyenteDto = new TipoContribuyenteDto();

        tipoContribuyenteDto.setId(tipoContribuyente.getId());
        tipoContribuyenteDto.setNombre(tipoContribuyente.getNombre());
        tipoContribuyenteDto.setEstado(tipoContribuyente.isEstado());

        return tipoContribuyenteDto;
    }

    public static TipoContribuyenteDto mapFromInsertDtoToModelDto(TipoContribuyenteInsertDto tipoContribuyenteInsertDto){

        TipoContribuyenteDto tipoContribuyenteDto = new TipoContribuyenteDto();

        tipoContribuyenteDto.setNombre(tipoContribuyenteInsertDto.getNombre());
        tipoContribuyenteDto.setEstado(true);
        return tipoContribuyenteDto;
    }


    public static TipoContribuyenteDto mapFromUpdateDtoToModelDto(TipoContribuyenteUpdateDto tipoContribuyenteUpdateDto){


        TipoContribuyenteDto tipoContribuyenteDto = new TipoContribuyenteDto();

        tipoContribuyenteDto.setId(tipoContribuyenteUpdateDto.getId());
        tipoContribuyenteDto.setNombre(tipoContribuyenteUpdateDto.getNombre());
        return tipoContribuyenteDto;
    }
    
    
}
