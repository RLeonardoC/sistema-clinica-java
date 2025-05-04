package service;

import model.Consulta;
import model.Cirurgia;

import java.util.ArrayList;
import java.util.List;

public class ClinicaService {
    private List<Consulta> consultas = new ArrayList<>();
    private List<Cirurgia> cirurgias = new ArrayList<>();

    public void adicionarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }

    public void adicionarCirurgia(Cirurgia cirurgia) {
        cirurgias.add(cirurgia);
    }

    public List<Consulta> listarConsultas() {
        return consultas;
    }

    public List<Cirurgia> listarCirurgias() {
        return cirurgias;
    }
}
