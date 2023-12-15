package com.jgq.josegutierrezbackendsintad.authentication.controller;

import com.jgq.josegutierrezbackendsintad.authentication.mapper.usuario.UsuarioMapper;
import com.jgq.josegutierrezbackendsintad.authentication.model.dto.LoginDto;
import com.jgq.josegutierrezbackendsintad.authentication.model.dto.UsuarioDto;
import com.jgq.josegutierrezbackendsintad.authentication.model.dto.UsuarioInsertDto;
import com.jgq.josegutierrezbackendsintad.authentication.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthenticationController {


    private final AuthenticationService authenticationService;


    @PostMapping("login")
    public ResponseEntity<HashMap<String,String>> login(@RequestBody @Valid LoginDto loginDto){

        try{
            String token = authenticationService.login(loginDto);
            HashMap<String,String> tokenHash = new HashMap<>();
            tokenHash.put("token",token);
            return new ResponseEntity<>(tokenHash, HttpStatusCode.valueOf(200));
        }catch(Exception ex){
            return new ResponseEntity<>(null, HttpStatusCode.valueOf(200));
        }

    }

    @PostMapping("registrar")
    public ResponseEntity<UsuarioDto> registrarUsuario(@RequestBody @Valid UsuarioInsertDto usuarioInsertDto){

        UsuarioDto usuarioDto = authenticationService.register(UsuarioMapper.mapFromCommandInsertToDto(usuarioInsertDto));

        if(usuarioDto == null) return new ResponseEntity<>(null,HttpStatusCode.valueOf(204));

        return new ResponseEntity<>(usuarioDto,HttpStatusCode.valueOf(200));

    }

}
