package com.appointment.org.appointment.models;
import jakarta.persistence.*;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Entity
public class Disponibilidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private Usuario professor;

    @Enumerated(EnumType.STRING)
    private DayOfWeek diaSemana;

    private LocalTime horarioInicio;
    private LocalTime horarioFim;

    // Construtores, getters e setters

    public Disponibilidade() {
        // Construtor padrão necessário para JPA
    }

    public Disponibilidade(Usuario professor, DayOfWeek diaSemana, LocalTime horarioInicio, LocalTime horarioFim) {
        this.professor = professor;
        this.diaSemana = diaSemana;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public LocalTime getHorarioFim() {
        return horarioFim;
    }

}
