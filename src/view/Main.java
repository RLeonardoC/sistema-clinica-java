package view;

import model.Consulta;
import model.Cirurgia;
import service.ClinicaService;
import service.expansao.*;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClinicaService service = new ClinicaService();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        while (true) {
            System.out.println("\n1. Marcar Consulta");
            System.out.println("2. Marcar Cirurgia");
            System.out.println("3. Listar Consultas");
            System.out.println("4. Listar Cirurgias");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.print("Paciente: ");
                    String paciente = scanner.nextLine();
                    System.out.print("Médico: ");
                    String medico = scanner.nextLine();
                    System.out.print("Data e hora (dd/MM/yyyy HH:mm): ");
                    LocalDateTime dataHoraConsulta = LocalDateTime.parse(scanner.nextLine(), formatter);
                    service.adicionarConsulta(new Consulta(paciente, medico, dataHoraConsulta));
                    System.out.println("Consulta marcada com sucesso.");
                    break;
                case "2":
                    System.out.print("Paciente: ");
                    String pacienteC = scanner.nextLine();
                    System.out.print("Médico: ");
                    String medicoC = scanner.nextLine();
                    System.out.print("Data e hora (dd/MM/yyyy HH:mm): ");
                    LocalDateTime dataHoraCirurgia = LocalDateTime.parse(scanner.nextLine(), formatter);
                    service.adicionarCirurgia(new Cirurgia(pacienteC, medicoC, dataHoraCirurgia));
                    System.out.println("Cirurgia marcada com sucesso.");
                    break;
                case "3":
                    System.out.println("\nConsultas:");
                    for (Consulta c : service.listarConsultas()) {
                        System.out.println(c);
                    }
                    break;
                case "4":
                    System.out.println("\nCirurgias:");
                    for (Cirurgia c : service.listarCirurgias()) {
                        System.out.println(c);
                    }
                    break;
                case "0":
                    System.out.println("Encerrando...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
