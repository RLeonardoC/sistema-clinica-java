package service;

import model.Paciente;
import repository.PacienteRepository;

public class ClinicaService {
    private PacienteRepository pacienteRepo = new PacienteRepository();

    public void cadastrarPaciente(String nome, String cpf) {
        Paciente novo = new Paciente(nome, cpf);
        pacienteRepo.adicionar(novo);
        System.out.println("Paciente cadastrado com sucesso!");
    }

    public void listarPacientes() {
        for (Paciente p : pacienteRepo.listarTodos()) {
            System.out.println(p);
        }
    }
}