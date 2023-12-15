package com.jgq.josegutierrezbackendsintad.entidad.controller;

import com.jgq.josegutierrezbackendsintad.entidad.api.EntidadResponse;
import com.jgq.josegutierrezbackendsintad.entidad.mapper.EntidadMapper;
import com.jgq.josegutierrezbackendsintad.entidad.model.dto.EntidadDto;
import com.jgq.josegutierrezbackendsintad.entidad.model.dto.EntidadInsertDto;
import com.jgq.josegutierrezbackendsintad.entidad.model.dto.EntidadUpdateDto;
import com.jgq.josegutierrezbackendsintad.entidad.service.EntidadService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/entidad")
@RequiredArgsConstructor
public class EntidadController {

    private final EntidadService<EntidadDto> entidadService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<EntidadResponse> listarEntidad(){
        List<EntidadDto> entidades = entidadService.getAll();
        EntidadResponse entidadResponse = new EntidadResponse();

        if(!entidades.isEmpty()){
            entidadResponse.setCode(200);
            entidadResponse.setContent(entidades);
            return new ResponseEntity<>(entidadResponse,HttpStatusCode.valueOf(200));
        }

        entidadResponse.setCode(200);
        entidadResponse.setContent(entidades);

        return new ResponseEntity<>(entidadResponse,HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<EntidadDto> guardarEntidad(@RequestBody @Valid EntidadInsertDto entidad){
        System.out.println("En guardar");
        try{
            System.out.println("En guardar 2");
            return new ResponseEntity<>(entidadService.save(EntidadMapper.mapFromInsertDtoToModelDto(entidad)),HttpStatusCode.valueOf(201));
        }catch(Exception ex){
            return new ResponseEntity<>(null, HttpStatusCode.valueOf(500));
        }
    }

    @PutMapping
    public ResponseEntity<EntidadDto> actualizarEntidad(@RequestBody @Valid EntidadUpdateDto entidad){
        try{
            return new ResponseEntity<>(entidadService.update(EntidadMapper.mapFromUpdateDtoToModelDto(entidad)),HttpStatusCode.valueOf(201));
        }catch(Exception ex){
            return new ResponseEntity<>(null,HttpStatusCode.valueOf(500));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntidadResponse> obtenerEntidadPorId(@PathVariable int id){
        EntidadDto entidadObt = entidadService.getById(id);
        EntidadResponse entidadResponse = new EntidadResponse();
        if(entidadObt!=null){
            entidadResponse.setCode(200);
            entidadResponse.setContent(List.of(entidadObt));
            return new ResponseEntity<>(entidadResponse,HttpStatusCode.valueOf(200));
        }
        entidadResponse.setCode(201);
        return new ResponseEntity<>(entidadResponse,HttpStatusCode.valueOf(404));
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> eliminarEntidadPorId(@PathVariable int id){
        boolean result = entidadService.delete(id);

        if(result){
            return new ResponseEntity<>(true,HttpStatusCode.valueOf(204));
        }
        return new ResponseEntity<>(false,HttpStatusCode.valueOf(404));
    }

    @GetMapping("desactivar/{id}")
    public ResponseEntity<Boolean> desactivarEntidad(@PathVariable int id){

        boolean result = entidadService.changeState(id,false);

        return new ResponseEntity<>(result,HttpStatusCode.valueOf(200));
    }

    @GetMapping("activar/{id}")
    public ResponseEntity<Boolean> activarEntidad(@PathVariable int id){

        boolean result = entidadService.changeState(id,true);

        return new ResponseEntity<>(result,HttpStatusCode.valueOf(200));
    }




}
