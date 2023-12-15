package com.jgq.josegutierrezbackendsintad.authentication.service.impl;

import com.jgq.josegutierrezbackendsintad.authentication.model.entity.Token;
import com.jgq.josegutierrezbackendsintad.authentication.repository.TokenRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyLogoutHandlerImpl implements LogoutHandler {

    private final TokenRepository tokenRepository;

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        String authHeader = request.getHeader("Authorization");
        String jwt = authHeader.substring(7);

        if (authHeader.isBlank() ||!authHeader.startsWith("Bearer ")) return;

        Token tokenAlmacenado = tokenRepository.findByToken(jwt)
                .orElse(null);

        if (tokenAlmacenado != null) {
            tokenAlmacenado.setExpirado(true);
            tokenAlmacenado.setRevocado(true);
            tokenRepository.save(tokenAlmacenado);
        }
    }
}
