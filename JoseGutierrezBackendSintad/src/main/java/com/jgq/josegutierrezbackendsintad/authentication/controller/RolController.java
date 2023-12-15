package com.jgq.josegutierrezbackendsintad.authentication.controller;

import com.jgq.josegutierrezbackendsintad.authentication.api.RolResponse;
import com.jgq.josegutierrezbackendsintad.authentication.model.dto.RolDto;
import com.jgq.josegutierrezbackendsintad.authentication.service.RolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/rol")
@RequiredArgsConstructor
public class RolController {

    private final RolService rolService;

    @GetMapping
    public ResponseEntity<RolResponse> obtenerRoles(){
        List<RolDto> roles = rolService.findAll();

        RolResponse rolResponse = new RolResponse();

        if(roles.size()>0){
            rolResponse.setCode(200);
            rolResponse.setContent(roles);
            return new ResponseEntity<>(rolResponse, HttpStatusCode.valueOf(200));
        }
        rolResponse.setCode(204);
        return new ResponseEntity<>(rolResponse, HttpStatusCode.valueOf(204));
    }

}
