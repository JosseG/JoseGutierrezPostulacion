package com.jgq.josegutierrezbackendsintad.entidad.service.impl;

import com.jgq.josegutierrezbackendsintad.entidad.mapper.EntidadMapper;
import com.jgq.josegutierrezbackendsintad.entidad.model.dto.EntidadDto;
import com.jgq.josegutierrezbackendsintad.entidad.model.entity.Entidad;
import com.jgq.josegutierrezbackendsintad.entidad.repository.EntidadRepository;
import com.jgq.josegutierrezbackendsintad.entidad.service.EntidadService;
import com.jgq.josegutierrezbackendsintad.tipocontribuyente.mapper.TipoContribuyenteMapper;
import com.jgq.josegutierrezbackendsintad.tipocontribuyente.model.dto.TipoContribuyenteDto;
import com.jgq.josegutierrezbackendsintad.tipocontribuyente.model.entity.TipoContribuyente;
import com.jgq.josegutierrezbackendsintad.tipocontribuyente.repository.TipoContribuyenteRepository;
import com.jgq.josegutierrezbackendsintad.tipodocumento.mapper.TipoDocumentoMapper;
import com.jgq.josegutierrezbackendsintad.tipodocumento.model.dto.TipoDocumentoDto;
import com.jgq.josegutierrezbackendsintad.tipodocumento.model.entity.TipoDocumento;
import com.jgq.josegutierrezbackendsintad.tipodocumento.repository.TipoDocumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EntidadServiceImpl implements EntidadService<EntidadDto> {


    private final EntidadRepository entidadRepository;
    private final TipoDocumentoRepository tipoDocumentoRepository;
    private final TipoContribuyenteRepository tipoContribuyenteRepository;

    @Override
    public EntidadDto save(EntidadDto object) {

        TipoDocumento tipoDocumento = tipoDocumentoRepository.findById(object.getTipoDocumento().getId()).orElse(null);
        TipoContribuyente tipoContribuyente = tipoContribuyenteRepository.findById(object.getTipoContribuyente().getId()).orElse(null);

        if(tipoDocumento == null && tipoContribuyente == null){
            return null;
        }

        Entidad entidad = EntidadMapper.mapToEntity(object);
        entidad.setTipoDocumento(tipoDocumento);
        entidad.setTipoContribuyente(tipoContribuyente);

        return EntidadMapper.mapToDto(entidadRepository.save(entidad));
    }

    @Override
    public List<EntidadDto> getAll() {

        List<Entidad> entidades = entidadRepository.findAll();

        List<EntidadDto> entidadDtos = entidades.stream().map(EntidadMapper::mapToDto).toList();

        for(int i=0;i<entidades.size();i++){
            entidadDtos.get(i).setTipoContribuyente(TipoContribuyenteMapper.mapToDto(entidades.get(i).getTipoContribuyente()));
            entidadDtos.get(i).setTipoDocumento(TipoDocumentoMapper.mapToDto(entidades.get(i).getTipoDocumento()));
        }

        return entidadDtos;
    }

    @Override
    public boolean delete(Object id) {

        try{
            entidadRepository.deleteById((int)id);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public EntidadDto getById(Object id) {
        Entidad entidad = entidadRepository.findById((int)id).orElse(null);

        if(entidad == null) return null;
        TipoContribuyenteDto tipoContribuyenteDto = TipoContribuyenteMapper.mapToDto(entidad.getTipoContribuyente());
        TipoDocumentoDto tipoDocumentoDto = TipoDocumentoMapper.mapToDto(entidad.getTipoDocumento());
        EntidadDto entidadDto = EntidadMapper.mapToDto(entidad);
        entidadDto.setTipoContribuyente(tipoContribuyenteDto);
        entidadDto.setTipoDocumento(tipoDocumentoDto);

        return entidadDto;
    }

    @Override
    public EntidadDto update(EntidadDto object) {

        Entidad entidad = entidadRepository.findById(object.getId()).orElse(null);
        if(entidad==null){
            return null;
        }

        TipoDocumento tipoDocumento = tipoDocumentoRepository.findById(object.getTipoDocumento().getId()).orElse(null);
        TipoContribuyente tipoContribuyente = tipoContribuyenteRepository.findById(object.getTipoContribuyente().getId()).orElse(null);


        if(tipoDocumento == null && tipoContribuyente == null){
            return null;
        }

        entidad.setTelefono(object.getTelefono());
        entidad.setDireccion(object.getDireccion());
        entidad.setNroDocumento(object.getNroDocumento());
        entidad.setRazonSocial(object.getRazonSocial());
        entidad.setNombreComercial(object.getNombreComercial());
        entidad.setTipoContribuyente(tipoContribuyente);
        entidad.setTipoDocumento(tipoDocumento);

        return EntidadMapper.mapToDto(entidadRepository.save(entidad));
    }

    @Override
    public boolean changeState(Object id,boolean estado) {
        Entidad entidad = entidadRepository.findById((int)id).orElse(null);
        if(entidad==null){
            return false;
        }
        entidad.setEstado(estado);
        entidadRepository.save(entidad);
        return true;
    }


}
