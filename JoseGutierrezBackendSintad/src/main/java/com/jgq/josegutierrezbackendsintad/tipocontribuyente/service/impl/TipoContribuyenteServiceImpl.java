package com.jgq.josegutierrezbackendsintad.tipocontribuyente.service.impl;

import com.jgq.josegutierrezbackendsintad.tipocontribuyente.mapper.TipoContribuyenteMapper;
import com.jgq.josegutierrezbackendsintad.tipocontribuyente.model.dto.TipoContribuyenteDto;
import com.jgq.josegutierrezbackendsintad.tipocontribuyente.model.entity.TipoContribuyente;
import com.jgq.josegutierrezbackendsintad.tipocontribuyente.repository.TipoContribuyenteRepository;
import com.jgq.josegutierrezbackendsintad.tipocontribuyente.service.TipoContribuyenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TipoContribuyenteServiceImpl implements TipoContribuyenteService<TipoContribuyenteDto> {

    private final TipoContribuyenteRepository tipoContribuyenteRepository;

    @Override
    public TipoContribuyenteDto save(TipoContribuyenteDto object) {

        TipoContribuyente tipoContribuyente = TipoContribuyenteMapper.mapToEntity(object);

        return TipoContribuyenteMapper.mapToDto(tipoContribuyenteRepository.save(tipoContribuyente));
    }

    @Override
    public List<TipoContribuyenteDto> getAll() {
        return tipoContribuyenteRepository.findAll().stream().map(TipoContribuyenteMapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public boolean delete(Object id) {

        try{
            tipoContribuyenteRepository.deleteById((int)id);
        }catch (Exception ex){
            return false;
        }
        return true;

    }

    @Override
    public TipoContribuyenteDto getById(Object id) {
        return tipoContribuyenteRepository.findById((int)id).map(TipoContribuyenteMapper::mapToDto).orElse(null);
    }

    @Override
    public TipoContribuyenteDto update(TipoContribuyenteDto object) {
        TipoContribuyente tipoContribuyente = tipoContribuyenteRepository.findById(object.getId()).orElse(null);

        if(tipoContribuyente == null){
            return null;
        }

        tipoContribuyente.setNombre(object.getNombre());
        return TipoContribuyenteMapper.mapToDto(tipoContribuyenteRepository.save(tipoContribuyente));
    }
    @Override
    public boolean changeState(Object id,boolean estado) {
        TipoContribuyente tipoContribuyente = tipoContribuyenteRepository.findById((int)id).orElse(null);
        if(tipoContribuyente==null){
            return false;
        }
        tipoContribuyente.setEstado(estado);
        tipoContribuyenteRepository.save(tipoContribuyente);
        return true;
    }
}
