package com.appointment.org.appointment.controllers;

import com.appointment.org.appointment.DTOs.LoginRequestDto;
import com.appointment.org.appointment.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.appointment.org.appointment.models.Usuario;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.findAll();
    }

    @PostMapping("/login")
    public String fazerLogin(@RequestBody LoginRequestDto loginRequest) {
        var email = loginRequest.getEmail();
        var password = loginRequest.getPassword();

        var usuario = usuarioService.findByEmailAndPassword(email, password);
        if (usuario != null) {
            return "Login bem-sucedido!";
        } else {
            return email;
        }
    }
}
