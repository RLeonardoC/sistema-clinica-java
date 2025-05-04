package model;

import java.time.LocalDateTime;

public class Cirurgia {
    private String paciente;
    private String medico;
    private LocalDateTime dataHora;

    public Cirurgia(String paciente, String medico, LocalDateTime dataHora) {
        this.paciente = paciente;
        this.medico = medico;
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "Cirurgia: " + paciente + " com " + medico + " em " + dataHora;
    }
}
