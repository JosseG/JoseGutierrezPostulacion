package com.jgq.josegutierrezbackendsintad.tipodocumento.mapper;

import com.jgq.josegutierrezbackendsintad.tipodocumento.model.dto.TipoDocumentoDto;
import com.jgq.josegutierrezbackendsintad.tipodocumento.model.dto.TipoDocumentoInsertDto;
import com.jgq.josegutierrezbackendsintad.tipodocumento.model.dto.TipoDocumentoUpdateDto;
import com.jgq.josegutierrezbackendsintad.tipodocumento.model.entity.TipoDocumento;

public class TipoDocumentoMapper {

    public static TipoDocumento mapToEntity(TipoDocumentoDto tipoDocumentoDto){
        TipoDocumento tipoDocumento = new TipoDocumento();

        tipoDocumento.setId(tipoDocumentoDto.getId());
        tipoDocumento.setNombre(tipoDocumentoDto.getNombre());
        tipoDocumento.setDescripcion(tipoDocumentoDto.getDescripcion());
        tipoDocumento.setEstado(tipoDocumentoDto.isEstado());

        return tipoDocumento;

    }

    public static TipoDocumentoDto mapToDto(TipoDocumento tipoDocumento){
        TipoDocumentoDto tipoDocumentoDto = new TipoDocumentoDto();

        tipoDocumentoDto.setId(tipoDocumento.getId());
        tipoDocumentoDto.setCodigo(tipoDocumento.getCodigo());
        tipoDocumentoDto.setNombre(tipoDocumento.getNombre());
        tipoDocumentoDto.setDescripcion(tipoDocumento.getDescripcion());
        tipoDocumentoDto.setEstado(tipoDocumento.isEstado());

        return tipoDocumentoDto;
    }

    public static TipoDocumentoDto mapFromInsertDtoToModelDto(TipoDocumentoInsertDto tipoDocumentoInsertDto){
        TipoDocumentoDto tipoDocumentoDto = new TipoDocumentoDto();

        tipoDocumentoDto.setNombre(tipoDocumentoInsertDto.getNombre());
        tipoDocumentoDto.setDescripcion(tipoDocumentoInsertDto.getDescripcion());
        tipoDocumentoDto.setEstado(true);
        return tipoDocumentoDto;
    }


    public static TipoDocumentoDto mapFromUpdateDtoToModelDto(TipoDocumentoUpdateDto tipoDocumentoUpdateDto){
        TipoDocumentoDto tipoDocumentoDto = new TipoDocumentoDto();

        tipoDocumentoDto.setId(tipoDocumentoUpdateDto.getId());
        tipoDocumentoDto.setDescripcion(tipoDocumentoUpdateDto.getDescripcion());
        tipoDocumentoDto.setNombre(tipoDocumentoUpdateDto.getNombre());
        return tipoDocumentoDto;
    }
    
}
