package com.appointment.org.appointment.DTOs;

public class LogonRequestDto extends LoginRequestDto{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
