package service;

import model.Consulta;
import model.Cirurgia;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ClinicaService {

    private List<Consulta> consultas = new ArrayList<>();
    private List<Cirurgia> cirurgias = new ArrayList<>();

    public void marcarConsulta(String paciente, String medico, LocalDateTime dataHora) {
        consultas.add(new Consulta(paciente, medico, dataHora));
    }

    public void marcarCirurgia(String paciente, String medico, String tipo, LocalDateTime dataHora) {
        cirurgias.add(new Cirurgia(paciente, medico, tipo, dataHora));
    }

    public List<Consulta> listarConsultas() {
        return consultas;
    }

    public List<Cirurgia> listarCirurgias() {
        return cirurgias;
    }
}