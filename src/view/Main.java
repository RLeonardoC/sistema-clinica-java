package view;

import java.util.Scanner;
import service.ClinicaService;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClinicaService service = new ClinicaService();

        while (true) {
            System.out.println("\n1. Cadastrar Paciente\n2. Listar Pacientes\n3. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // consumir linha

            if (opcao == 1) {
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("CPF: ");
                String cpf = scanner.nextLine();
                service.cadastrarPaciente(nome, cpf);
            } else if (opcao == 2) {
                service.listarPacientes();
            } else if (opcao == 3) {
                break;
            } else {
                System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }
}