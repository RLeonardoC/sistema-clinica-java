package model;

import java.time.LocalDateTime;

public class Cirurgia {
    private String paciente;
    private String medico;
    private String tipo;
    private LocalDateTime dataHora;

    public Cirurgia(String paciente, String medico, String tipo, LocalDateTime dataHora) {
        this.paciente = paciente;
        this.medico = medico;
        this.tipo = tipo;
        this.dataHora = dataHora;
    }

    public String getPaciente() { return paciente; }
    public String getMedico() { return medico; }
    public String getTipo() { return tipo; }
    public LocalDateTime getDataHora() { return dataHora; }

    @Override
    public String toString() {
        return "Cirurgia de " + tipo + " com " + medico + " para " + paciente + " em " + dataHora;
    }
}