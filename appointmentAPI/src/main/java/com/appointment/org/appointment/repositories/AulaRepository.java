package com.appointment.org.appointment.repositories;

import com.appointment.org.appointment.models.Aula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AulaRepository extends JpaRepository<Aula, Long> {
    List<Aula> findByProfessorIdAndDataInicioBetween(Long professorId, LocalDateTime dataInicio, LocalDateTime dataFim);

}
