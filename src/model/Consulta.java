package model;

import java.time.LocalDateTime;

public class Consulta {
    private String paciente;
    private String medico;
    private LocalDateTime dataHora;

    public Consulta(String paciente, String medico, LocalDateTime dataHora) {
        this.paciente = paciente;
        this.medico = medico;
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "Consulta: " + paciente + " com " + medico + " em " + dataHora;
    }
}
