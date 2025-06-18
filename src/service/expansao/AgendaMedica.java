package sistema.expansao;

import modelo.Consulta;
import modelo.Cirurgia;
import java.util.List;
import java.time.LocalDateTime;

public class AgendaMedica {

    public void cancelarConsulta(List<Consulta> consultas, Consulta c) {
        consultas.remove(c);
    }

    public void reagendarConsulta(Consulta c, LocalDateTime novaDataHora) {
        c.setDataHora(novaDataHora);
    }
}