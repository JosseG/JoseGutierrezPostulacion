package com.jgq.josegutierrezbackendsintad.entidad.mapper;

import com.jgq.josegutierrezbackendsintad.entidad.model.dto.EntidadDto;
import com.jgq.josegutierrezbackendsintad.entidad.model.dto.EntidadInsertDto;
import com.jgq.josegutierrezbackendsintad.entidad.model.dto.EntidadUpdateDto;
import com.jgq.josegutierrezbackendsintad.entidad.model.entity.Entidad;
import com.jgq.josegutierrezbackendsintad.tipocontribuyente.model.dto.TipoContribuyenteDto;
import com.jgq.josegutierrezbackendsintad.tipodocumento.model.dto.TipoDocumentoDto;

public class EntidadMapper {


    public static Entidad mapToEntity(EntidadDto entidadDto){

        Entidad entidad = new Entidad();

        entidad.setId(entidadDto.getId());
        entidad.setRazonSocial(entidadDto.getRazonSocial());
        entidad.setNombreComercial(entidadDto.getNombreComercial());
        entidad.setNroDocumento(entidadDto.getNroDocumento());
        entidad.setTelefono(entidadDto.getTelefono());
        entidad.setDireccion(entidadDto.getDireccion());
        entidad.setEstado(entidadDto.isEstado());

        return entidad;

    }

    public static EntidadDto mapToDto(Entidad entidad){
        EntidadDto entidadDto = new EntidadDto();

        entidadDto.setId(entidad.getId());
        entidadDto.setNroDocumento(entidad.getNroDocumento());
        entidadDto.setRazonSocial(entidad.getRazonSocial());
        entidadDto.setNombreComercial(entidad.getNombreComercial());
        entidadDto.setDireccion(entidad.getDireccion());
        entidadDto.setTelefono(entidad.getTelefono());
        entidadDto.setEstado(entidad.isEstado());

        return entidadDto;
    }

    public static EntidadDto mapFromInsertDtoToModelDto(EntidadInsertDto entidadInsertDto){

        TipoDocumentoDto tipoDocumentoDto = new TipoDocumentoDto();
        tipoDocumentoDto.setId(entidadInsertDto.getIdTipoDocumento());

        TipoContribuyenteDto tipoContribuyenteDto = new TipoContribuyenteDto();
        tipoContribuyenteDto.setId(entidadInsertDto.getIdTipoContribuyente());


        EntidadDto entidadDto = new EntidadDto();

        entidadDto.setNroDocumento(entidadInsertDto.getNroDocumento());
        entidadDto.setTelefono(entidadInsertDto.getTelefono());
        entidadDto.setRazonSocial(entidadInsertDto.getRazonSocial());
        entidadDto.setNombreComercial(entidadInsertDto.getNombreComercial());
        entidadDto.setDireccion(entidadInsertDto.getDireccion());
        entidadDto.setEstado(true);
        entidadDto.setTipoDocumento(tipoDocumentoDto);
        entidadDto.setTipoContribuyente(tipoContribuyenteDto);
        return entidadDto;
    }


    public static EntidadDto mapFromUpdateDtoToModelDto(EntidadUpdateDto entidadUpdateDto){

        TipoDocumentoDto tipoDocumentoDto = new TipoDocumentoDto();
        tipoDocumentoDto.setId(entidadUpdateDto.getIdTipoDocumento());

        TipoContribuyenteDto tipoContribuyenteDto = new TipoContribuyenteDto();
        tipoContribuyenteDto.setId(entidadUpdateDto.getIdTipoContribuyente());

        EntidadDto entidadDto = new EntidadDto();

        entidadDto.setId(entidadUpdateDto.getId());
        entidadDto.setNroDocumento(entidadUpdateDto.getNroDocumento());
        entidadDto.setRazonSocial(entidadUpdateDto.getRazonSocial());
        entidadDto.setNombreComercial(entidadUpdateDto.getNombreComercial());
        entidadDto.setTelefono(entidadUpdateDto.getTelefono());
        entidadDto.setDireccion(entidadUpdateDto.getDireccion());
        entidadDto.setTipoDocumento(tipoDocumentoDto);
        entidadDto.setTipoContribuyente(tipoContribuyenteDto);
        return entidadDto;
    }


}
