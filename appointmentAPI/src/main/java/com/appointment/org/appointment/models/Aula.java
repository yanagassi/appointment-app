package com.appointment.org.appointment.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private Usuario professor;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Usuario aluno;

    private LocalDateTime dataInicio;
    private int duracaoMinutos;

    // Construtores, getters e setters

    public Aula() {
        // Construtor padrão necessário para JPA
    }

    public Aula(Usuario professor, Usuario aluno, LocalDateTime dataInicio, int duracaoMinutos) {
        this.professor = professor;
        this.aluno = aluno;
        this.dataInicio = dataInicio;
        this.duracaoMinutos = duracaoMinutos;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }


}
