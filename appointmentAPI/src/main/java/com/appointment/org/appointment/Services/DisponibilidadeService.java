package com.appointment.org.appointment.Services;
import com.appointment.org.appointment.models.Aula;
import com.appointment.org.appointment.models.Disponibilidade;
import com.appointment.org.appointment.repositories.AulaRepository;
import com.appointment.org.appointment.repositories.DisponibilidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DisponibilidadeService {

    @Autowired
    private DisponibilidadeRepository disponibilidadeRepository;

    @Autowired
    private AulaRepository aulaRepository;

    public List<Disponibilidade> calcularDisponibilidadeSemana(Long professorId, DayOfWeek diaSemana) {
        // Obter as disponibilidades cadastradas para o professor na semana específica
        List<Disponibilidade> disponibilidades = disponibilidadeRepository.findByProfessorIdAndDiaSemana(professorId, diaSemana);

        // Obter as aulas agendadas para o professor na semana específica
        List<Aula> aulasAgendadas = aulaRepository.findByProfessorIdAndDataInicioBetween(
                professorId,
                LocalDateTime.now().with(TemporalAdjusters.nextOrSame(diaSemana)).with(LocalTime.MIN),
                LocalDateTime.now().with(TemporalAdjusters.nextOrSame(diaSemana)).with(LocalTime.MAX)
        );

        // Filtrar as disponibilidades com base nas aulas agendadas
        List<Disponibilidade> disponibilidadesDisponiveis = disponibilidades.stream()
                .filter(disponibilidade ->
                        aulasAgendadas.stream()
                                .noneMatch(aula ->
                                        aula.getDataInicio().isAfter(disponibilidade.getHorarioInicio().atDate(LocalDate.now()))
                                                && aula.getDataInicio().plusMinutes(aula.getDuracaoMinutos()).isBefore(disponibilidade.getHorarioFim().atDate(LocalDate.now()))
                                )
                )
                .collect(Collectors.toList());

        return disponibilidadesDisponiveis;
    }
}
