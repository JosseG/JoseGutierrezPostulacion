package com.jgq.josegutierrezbackendsintad.tipodocumento.service.impl;

import com.jgq.josegutierrezbackendsintad.tipodocumento.mapper.TipoDocumentoMapper;
import com.jgq.josegutierrezbackendsintad.tipodocumento.model.dto.TipoDocumentoDto;
import com.jgq.josegutierrezbackendsintad.tipodocumento.model.entity.TipoDocumento;
import com.jgq.josegutierrezbackendsintad.tipodocumento.repository.TipoDocumentoRepository;
import com.jgq.josegutierrezbackendsintad.tipodocumento.service.TipoDocumentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TipoDocumentoServiceImpl implements TipoDocumentoService<TipoDocumentoDto> {

    private final TipoDocumentoRepository tipoDocumentoRepository;

    @Override
    public TipoDocumentoDto save(TipoDocumentoDto object) {

        TipoDocumento tipoDocumento = TipoDocumentoMapper.mapToEntity(object);

        return TipoDocumentoMapper.mapToDto(tipoDocumentoRepository.save(tipoDocumento));
    }

    @Override
    public List<TipoDocumentoDto> getAll() {
        return tipoDocumentoRepository.findAll().stream().map(TipoDocumentoMapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public boolean delete(Object id) {
        try{
            tipoDocumentoRepository.deleteById((int)id);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public TipoDocumentoDto getById(Object id) {
        return tipoDocumentoRepository.findById((int)id).map(TipoDocumentoMapper::mapToDto).orElse(null);
    }

    @Override
    public TipoDocumentoDto update(TipoDocumentoDto object) {
        TipoDocumento tipoDocumento = tipoDocumentoRepository.findById(object.getId()).orElse(null);

        if(tipoDocumento == null){
            return null;
        }

        tipoDocumento.setNombre(object.getNombre());
        tipoDocumento.setDescripcion(object.getDescripcion());

        return TipoDocumentoMapper.mapToDto(tipoDocumentoRepository.save(tipoDocumento));
    }
    @Override
    public boolean changeState(Object id,boolean estado) {
        TipoDocumento tipoDocumento = tipoDocumentoRepository.findById((int)id).orElse(null);
        if(tipoDocumento==null){
            return false;
        }
        tipoDocumento.setEstado(estado);
        tipoDocumentoRepository.save(tipoDocumento);
        return true;
    }
}
