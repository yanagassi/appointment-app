package com.appointment.org.appointment.DTOs;

import java.time.DayOfWeek;

public class CalculoDisponibildadeDto {

    private Long professorId;
    private DayOfWeek diaSemana;

    public Long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }

    public DayOfWeek getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DayOfWeek diaSemana) {
        this.diaSemana = diaSemana;
    }
}
