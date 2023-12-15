package com.jgq.josegutierrezbackendsintad.tipodocumento.controller;

import com.jgq.josegutierrezbackendsintad.tipodocumento.api.TipoDocumentoResponse;
import com.jgq.josegutierrezbackendsintad.tipodocumento.mapper.TipoDocumentoMapper;
import com.jgq.josegutierrezbackendsintad.tipodocumento.model.dto.TipoDocumentoDto;
import com.jgq.josegutierrezbackendsintad.tipodocumento.model.dto.TipoDocumentoInsertDto;
import com.jgq.josegutierrezbackendsintad.tipodocumento.model.dto.TipoDocumentoUpdateDto;
import com.jgq.josegutierrezbackendsintad.tipodocumento.service.TipoDocumentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/tipodocumento")
public class TipoDocumentoController {


    private final TipoDocumentoService<TipoDocumentoDto> tipoDocumentoService;

    @GetMapping
    public ResponseEntity<TipoDocumentoResponse> listarTipoDocumento(){
        List<TipoDocumentoDto> tipoDocumentos = tipoDocumentoService.getAll();
        TipoDocumentoResponse tipoDocumentoResponse = new TipoDocumentoResponse();

        if(!tipoDocumentos.isEmpty()){
            tipoDocumentoResponse.setCode(200);
            tipoDocumentoResponse.setContent(tipoDocumentos);
            return new ResponseEntity<>(tipoDocumentoResponse,HttpStatusCode.valueOf(200));
        }

        tipoDocumentoResponse.setCode(201);

        return new ResponseEntity<>(tipoDocumentoResponse,HttpStatusCode.valueOf(201));
    }

    @PostMapping
    public ResponseEntity<TipoDocumentoDto> guardarTipoDocumento(@RequestBody @Valid TipoDocumentoInsertDto tipoDocumento){
        try{
            return new ResponseEntity<>(tipoDocumentoService.save(TipoDocumentoMapper.mapFromInsertDtoToModelDto(tipoDocumento)), HttpStatusCode.valueOf(201));
        }catch(Exception ex){
            return new ResponseEntity<>(null, HttpStatusCode.valueOf(500));
        }
    }

    @PutMapping
    public ResponseEntity<TipoDocumentoDto> actualizarTipoDocumento(@RequestBody @Valid TipoDocumentoUpdateDto tipoDocumento){
        try{
            return new ResponseEntity<>(tipoDocumentoService.update(TipoDocumentoMapper.mapFromUpdateDtoToModelDto(tipoDocumento)),HttpStatusCode.valueOf(201));
        }catch(Exception ex){
            return new ResponseEntity<>(null,HttpStatusCode.valueOf(500));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoDocumentoResponse> obtenerTipoDocumentoPorId(@PathVariable int id){
        TipoDocumentoDto tipoDocumentoObt = tipoDocumentoService.getById(id);
        TipoDocumentoResponse tipoDocumentoResponse = new TipoDocumentoResponse();
        if(tipoDocumentoObt!=null){
            tipoDocumentoResponse.setCode(200);
            tipoDocumentoResponse.setContent(List.of(tipoDocumentoObt));
            return new ResponseEntity<>(tipoDocumentoResponse,HttpStatusCode.valueOf(200));
        }

        tipoDocumentoResponse.setCode(201);
        return new ResponseEntity<>(tipoDocumentoResponse,HttpStatusCode.valueOf(404));
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> eliminarTipoDocumentoPorId(@PathVariable int id){
        boolean result = tipoDocumentoService.delete(id);

        if(result){
            return new ResponseEntity<>(true,HttpStatusCode.valueOf(204));
        }
        return new ResponseEntity<>(false,HttpStatusCode.valueOf(404));
    }

    @GetMapping("/desactivar/{id}")
    public ResponseEntity<Boolean> desactivarTipoDocumento(@PathVariable int id){

        boolean result = tipoDocumentoService.changeState(id,false);

        return new ResponseEntity<>(result,HttpStatusCode.valueOf(200));
    }

    @GetMapping("/activar/{id}")
    public ResponseEntity<Boolean> activarTipoDocumento(@PathVariable int id){

        boolean result = tipoDocumentoService.changeState(id,true);

        return new ResponseEntity<>(result,HttpStatusCode.valueOf(200));
    }
}
