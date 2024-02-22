package com.appointment.org.appointment.Services;

import com.appointment.org.appointment.config.JwtTokenUtil;
import com.appointment.org.appointment.models.Usuario;
import com.appointment.org.appointment.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public String findByEmailAndPassword(String email, String password) {
        var user = usuarioRepository.findByEmail(email);
        var validationPass = passwordEncoder.matches(password, user.getPassword());

        if (user != null && validationPass) {
            var token = jwtTokenUtil.generateToken(user, true);
            return  token;
        } else {
            return null;
        }
    }

    public String createAccount(Usuario user) {
        // Verifica se o usuário já existe
        var exists = usuarioRepository.findByEmail(user.getEmail());
        if(exists != null)
            return null;

        // Hash da senha antes de salvar no banco de dados
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        usuarioRepository.save(user);
        return jwtTokenUtil.generateToken(user, true);
    }
}
