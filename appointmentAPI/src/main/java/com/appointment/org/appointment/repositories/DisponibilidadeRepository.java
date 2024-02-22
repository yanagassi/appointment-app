package com.appointment.org.appointment.repositories;

import com.appointment.org.appointment.models.Disponibilidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.DayOfWeek;
import java.util.List;

public interface DisponibilidadeRepository extends JpaRepository<Disponibilidade, Long> {
    List<Disponibilidade> findByProfessorIdAndDiaSemana(Long professorId, DayOfWeek diaSemana);
    // Outros métodos de consulta podem ser adicionados conforme necessário
}
