package com.jgq.josegutierrezbackendsintad.authentication.service.impl;

import com.jgq.josegutierrezbackendsintad.authentication.mapper.usuario.UsuarioMapper;
import com.jgq.josegutierrezbackendsintad.authentication.model.dto.LoginDto;
import com.jgq.josegutierrezbackendsintad.authentication.model.dto.UsuarioDto;
import com.jgq.josegutierrezbackendsintad.authentication.model.entity.Rol;
import com.jgq.josegutierrezbackendsintad.authentication.model.entity.Token;
import com.jgq.josegutierrezbackendsintad.authentication.model.entity.Usuario;
import com.jgq.josegutierrezbackendsintad.authentication.repository.RolRepository;
import com.jgq.josegutierrezbackendsintad.authentication.repository.TokenRepository;
import com.jgq.josegutierrezbackendsintad.authentication.repository.UsuarioRepository;
import com.jgq.josegutierrezbackendsintad.authentication.service.AuthenticationService;
import com.jgq.josegutierrezbackendsintad.security.jwt.service.JwtService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final TokenRepository tokenRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    @Override
    public String login(LoginDto loginDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(),
                        loginDto.getPassword()
                )
        );

        Usuario usuario = usuarioRepository.findUsuarioByUsername(loginDto.getUsername()).orElseThrow(() -> new UsernameNotFoundException("Error no encontrado"));


        User user =  mapToUser(usuario);
        var jwtToken = jwtService.generateToken(user);
        revokeAllUserTokens(usuario);
        saveUserToken(usuario, jwtToken);
        return jwtToken;
    }

    @Override
    @Transactional(rollbackOn = {Exception.class})
    public UsuarioDto register(UsuarioDto usuarioDto) {
        try {

            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
            Rol rol = rolRepository.findById(usuarioDto.getRol().getId()).orElse(null);

            Usuario usuarioObt = UsuarioMapper.mapToEntity(usuarioDto);

            usuarioObt.setRol(rol);
            usuarioObt.setPassword(bCryptPasswordEncoder.encode(usuarioObt.getPassword()));

            Usuario usuarioSaved = usuarioRepository.save(usuarioObt);

            User usuarioParsed =  mapToUser(usuarioSaved);

            String jwtToken = jwtService.generateToken(usuarioParsed);
            saveUserToken(usuarioSaved, jwtToken);

            return UsuarioMapper.mapToDto(usuarioSaved);
        }catch (Exception ex){
            return null;
        }
    }




    private void saveUserToken(Usuario usuario, String jwtToken) {
        Token token = new Token();
        token.setUsuario(usuario);
        token.setToken(jwtToken);
        token.setExpirado(false);
        token.setRevocado(false);
        tokenRepository.save(token);
    }



    private void revokeAllUserTokens(Usuario usuario) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(usuario.getId());

        if (validUserTokens.isEmpty()) return;

        validUserTokens.forEach(token -> {
            token.setExpirado(true);
            token.setRevocado(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }


    public User mapToUser(Usuario usuarioEntity){
        GrantedAuthority rol = new SimpleGrantedAuthority("ROLE_".concat(usuarioEntity.getRol().getNombre()));
        Set<GrantedAuthority> listaRoles = Set.of(rol);
        for(GrantedAuthority g: listaRoles){
            System.out.println("Es es la autoridad " + g.getAuthority());
        }
        return new User(usuarioEntity.getUsername(), usuarioEntity.getPassword(), listaRoles);
    }

}
