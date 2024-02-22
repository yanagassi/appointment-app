package com.appointment.org.appointment.controllers;

import com.appointment.org.appointment.DTOs.LoginRequestDto;
import com.appointment.org.appointment.DTOs.LogonRequestDto;
import com.appointment.org.appointment.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.appointment.org.appointment.models.Usuario;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController extends  BaseController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return null;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> fazerLogin(@RequestBody LoginRequestDto loginRequest) {
        var email = loginRequest.getEmail();
        var password = loginRequest.getPassword();

        var token = usuarioService.findByEmailAndPassword(email, password);
        var responseBody = Map.of("token", token);
        return ResponseEntity.ok(responseBody);
    }

    @PostMapping("/register")
    public ResponseEntity<Object> criarLogin(@RequestBody LogonRequestDto loginRequest) {
        var email = loginRequest.getEmail();
        var password = loginRequest.getPassword();
        var name = loginRequest.getName();

        var token = usuarioService.createAccount(new Usuario(name,email, password));
        var responseBody = Map.of("token", token);
        return ResponseEntity.ok(responseBody);
    }
}
