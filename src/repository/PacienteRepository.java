package repository;

import java.util.ArrayList;
import java.util.List;
import model.Paciente;

public class PacienteRepository {
    private List<Paciente> pacientes = new ArrayList<>();

    public void adicionar(Paciente p) {
        pacientes.add(p);
    }

    public List<Paciente> listarTodos() {
        return pacientes;
    }
}