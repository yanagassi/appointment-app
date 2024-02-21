package com.appointment.org.appointment.Services;

import com.appointment.org.appointment.models.Usuario;
import com.appointment.org.appointment.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findByEmailAndPassword(String email, String password) {
        // Aqui você deve implementar a lógica para encontrar um usuário por e-mail e senha
        // Exemplo básico: apenas retorna o usuário com correspondência exata
        return null;
    }
}
