package com.appointment.org.appointment.repositories;

import com.appointment.org.appointment.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
