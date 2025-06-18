package service.expansao;


import model.Consulta;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Relatorio {
    public void gerarRelatorioConsultas(List<Consulta> consultas) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("relatorio_consultas.txt"));

        for (Consulta c : consultas) {
            writer.write("Paciente: " + c.getPaciente()
           + " | Médico: " + c.getMedico()
           + " | Data: " + c.getDataHora().toString() + "\n");

        }

        writer.close();
    }
}