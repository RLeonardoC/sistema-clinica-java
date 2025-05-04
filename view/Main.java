package view;

import service.ClinicaService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClinicaService service = new ClinicaService();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n1. Marcar Consulta");
            System.out.println("2. Marcar Cirurgia");
            System.out.println("3. Listar Consultas");
            System.out.println("4. Listar Cirurgias");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.print("Paciente: ");
                    String pacienteConsulta = scanner.nextLine();
                    System.out.print("Médico: ");
                    String medicoConsulta = scanner.nextLine();
                    System.out.print("Data e hora (dd/MM/yyyy HH:mm): ");
                    LocalDateTime dataHoraConsulta = LocalDateTime.parse(scanner.nextLine(), formatter);
                    service.marcarConsulta(pacienteConsulta, medicoConsulta, dataHoraConsulta);
                    break;
                case 2:
                    System.out.print("Paciente: ");
                    String pacienteCirurgia = scanner.nextLine();
                    System.out.print("Médico: ");
                    String medicoCirurgia = scanner.nextLine();
                    System.out.print("Tipo de cirurgia: ");
                    String tipo = scanner.nextLine();
                    System.out.print("Data e hora (dd/MM/yyyy HH:mm): ");
                    LocalDateTime dataHoraCirurgia = LocalDateTime.parse(scanner.nextLine(), formatter);
                    service.marcarCirurgia(pacienteCirurgia, medicoCirurgia, tipo, dataHoraCirurgia);
                    break;
                case 3:
                    service.listarConsultas().forEach(System.out::println);
                    break;
                case 4:
                    service.listarCirurgias().forEach(System.out::println);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }
}