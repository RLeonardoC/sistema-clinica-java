package view;

import model.*;
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

        // Autenticação
        Usuario recepcionista = new Recepcionista("Maria", "maria", "123");
        Autenticacao auth = new Autenticacao(java.util.List.of(recepcionista));

        System.out.println("=== Login ===");
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Usuario logado = auth.logar(login, senha);
        if (logado == null || !logado.getPerfil().equals("RECEPCIONISTA")) {
            System.out.println("Login inválido ou sem permissão.");
            return;
        }
        System.out.println("Bem-vindo, " + logado.getNome());

        while (true) {
            System.out.println("\n1. Marcar Consulta");
            System.out.println("2. Marcar Cirurgia");
            System.out.println("3. Listar Consultas");
            System.out.println("4. Listar Cirurgias");
            System.out.println("5. Reagendar Consulta");
            System.out.println("6. Gerar Relatório de Consultas");
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

                    Consulta consulta = new Consulta(paciente, medico, dataHoraConsulta);
                    service.adicionarConsulta(consulta);

                    Paciente pacienteObj = new Paciente(paciente, "000.000.000-00");
                    pacienteObj.getProntuario().adicionarRegistro("Consulta marcada com " + medico + " para " + dataHoraConsulta);
                    Notificador notificador = new Notificador();
                    notificador.enviarNotificacao(pacienteObj, "Sua consulta foi marcada para " + dataHoraConsulta.format(formatter));

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

                case "5":
                    System.out.println("\nConsultas:");
                    var consultas = service.listarConsultas();
                    for (int i = 0; i < consultas.size(); i++) {
                        System.out.println(i + " - " + consultas.get(i));
                    }
                    System.out.print("Escolha o número da consulta: ");
                    int index = Integer.parseInt(scanner.nextLine());

                    if (index >= 0 && index < consultas.size()) {
                        System.out.print("Nova data e hora (dd/MM/yyyy HH:mm): ");
                        LocalDateTime novaData = LocalDateTime.parse(scanner.nextLine(), formatter);
                        AgendaMedica agenda = new AgendaMedica();
                        agenda.reagendarConsulta(consultas.get(index), novaData);
                        System.out.println("Consulta reagendada.");
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;

                case "6":
                    Relatorio rel = new Relatorio();
                    try {
                        rel.gerarRelatorioConsultas(service.listarConsultas());
                        System.out.println("Relatório gerado: relatorio_consultas.txt");
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
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