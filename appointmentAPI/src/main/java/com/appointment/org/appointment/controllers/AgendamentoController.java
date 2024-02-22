package com.appointment.org.appointment.controllers;

import com.appointment.org.appointment.DTOs.CalculoDisponibildadeDto;
import com.appointment.org.appointment.Services.DisponibilidadeService;
import com.appointment.org.appointment.Services.UsuarioService;
import com.appointment.org.appointment.models.Aula;
import com.appointment.org.appointment.models.Disponibilidade;
import com.appointment.org.appointment.models.Usuario;
import com.appointment.org.appointment.repositories.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.List;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController extends  BaseController {
    @Autowired
    private DisponibilidadeService disponibilidadeService;

    @PostMapping
    public List<Disponibilidade> listarAgendamentos(@RequestBody CalculoDisponibildadeDto calculoDisponibildadreq) {
        var diaSemana = calculoDisponibildadreq.getDiaSemana();
        var professorId = calculoDisponibildadreq.getProfessorId();

        return disponibilidadeService.calcularDisponibilidadeSemana(professorId, diaSemana);
    }

}
