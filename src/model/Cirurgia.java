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

    @Override
    public String toString() {
        return "Cirurgia: " + paciente + " com " + medico + " (" + tipo + ") em " + dataHora;
    }
}
