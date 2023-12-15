package com.jgq.josegutierrezbackendsintad.authentication.service.impl;

import com.jgq.josegutierrezbackendsintad.authentication.mapper.rol.RolMapper;
import com.jgq.josegutierrezbackendsintad.authentication.model.dto.RolDto;
import com.jgq.josegutierrezbackendsintad.authentication.repository.RolRepository;
import com.jgq.josegutierrezbackendsintad.authentication.service.RolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;

    @Override
    public List<RolDto> findAll() {
        return rolRepository.findAll().stream().map(RolMapper::mapToDto).collect(Collectors.toList());
    }
}
