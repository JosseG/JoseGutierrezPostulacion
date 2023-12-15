package com.jgq.josegutierrezbackendsintad.tipocontribuyente.controller;

import com.jgq.josegutierrezbackendsintad.tipocontribuyente.api.TipoContribuyenteResponse;
import com.jgq.josegutierrezbackendsintad.tipocontribuyente.mapper.TipoContribuyenteMapper;
import com.jgq.josegutierrezbackendsintad.tipocontribuyente.model.dto.TipoContribuyenteDto;
import com.jgq.josegutierrezbackendsintad.tipocontribuyente.model.dto.TipoContribuyenteInsertDto;
import com.jgq.josegutierrezbackendsintad.tipocontribuyente.model.dto.TipoContribuyenteUpdateDto;
import com.jgq.josegutierrezbackendsintad.tipocontribuyente.service.TipoContribuyenteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/tipocontribuyente")
public class TipoContribuyenteController {

    private final TipoContribuyenteService<TipoContribuyenteDto> tipoContribuyenteService;


    @GetMapping
    public ResponseEntity<TipoContribuyenteResponse> listarTipoContribuyente(){
        List<TipoContribuyenteDto> tipoContribuyentes = tipoContribuyenteService.getAll();
        TipoContribuyenteResponse tipoContribuyenteResponse = new TipoContribuyenteResponse();

        if(!tipoContribuyentes.isEmpty()){
            tipoContribuyenteResponse.setCode(200);
            tipoContribuyenteResponse.setContent(tipoContribuyentes);
            return new ResponseEntity<>(tipoContribuyenteResponse,HttpStatusCode.valueOf(200));
        }

        tipoContribuyenteResponse.setCode(201);

        return new ResponseEntity<>(tipoContribuyenteResponse,HttpStatusCode.valueOf(201));
    }


    @PostMapping
    public ResponseEntity<TipoContribuyenteDto> guardarTipoContribuyente(@RequestBody @Valid TipoContribuyenteInsertDto tipoContribuyente){
        try{
            return new ResponseEntity<>(tipoContribuyenteService.save(TipoContribuyenteMapper.mapFromInsertDtoToModelDto(tipoContribuyente)), HttpStatusCode.valueOf(201));
        }catch(Exception ex){
            return new ResponseEntity<>(null, HttpStatusCode.valueOf(500));
        }
    }

    @PutMapping
    public ResponseEntity<TipoContribuyenteDto> actualizarTipoContribuyente(@RequestBody @Valid TipoContribuyenteUpdateDto tipoContribuyente){
        try{
            return new ResponseEntity<>(tipoContribuyenteService.update(TipoContribuyenteMapper.mapFromUpdateDtoToModelDto(tipoContribuyente)),HttpStatusCode.valueOf(201));
        }catch(Exception ex){
            return new ResponseEntity<>(null,HttpStatusCode.valueOf(500));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoContribuyenteResponse> obtenerTipoContribuyentePorId(@PathVariable int id){
        TipoContribuyenteDto tipoContribuyenteObt = tipoContribuyenteService.getById(id);
        TipoContribuyenteResponse tipoContribuyenteResponse = new TipoContribuyenteResponse();
        if(tipoContribuyenteObt!=null){
            tipoContribuyenteResponse.setCode(200);
            tipoContribuyenteResponse.setContent(List.of(tipoContribuyenteObt));
            return new ResponseEntity<>(tipoContribuyenteResponse,HttpStatusCode.valueOf(200));
        }
        tipoContribuyenteResponse.setCode(204);
        return new ResponseEntity<>(tipoContribuyenteResponse,HttpStatusCode.valueOf(404));
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> eliminarTipoContribuyentePorId(@PathVariable int id){
        boolean result = tipoContribuyenteService.delete(id);

        if(result){
            return new ResponseEntity<>(true,HttpStatusCode.valueOf(204));
        }
        return new ResponseEntity<>(false,HttpStatusCode.valueOf(404));
    }

    @GetMapping("/desactivar/{id}")
    public ResponseEntity<Boolean> desactivarTipoContribuyente(@PathVariable int id){

        boolean result = tipoContribuyenteService.changeState(id,false);

        return new ResponseEntity<>(result,HttpStatusCode.valueOf(200));
    }

    @GetMapping("/activar/{id}")
    public ResponseEntity<Boolean> activarTipoContribuyente(@PathVariable int id){

        boolean result = tipoContribuyenteService.changeState(id,true);

        return new ResponseEntity<>(result,HttpStatusCode.valueOf(200));
    }

}
