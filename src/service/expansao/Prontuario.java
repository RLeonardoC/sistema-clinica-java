package service.expansao;


import java.util.ArrayList;
import java.util.List;

public class Prontuario {
    private List<String> registros = new ArrayList<>();

    public void adicionarRegistro(String texto) {
        registros.add(texto);
    }

    public List<String> getRegistros() {
        return registros;
    }
}