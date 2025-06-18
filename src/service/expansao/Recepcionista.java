package service.expansao;


public class Recepcionista extends Usuario {
    public Recepcionista(String nome, String login, String senha) {
        super(nome, login, senha);
    }

    public String getPerfil() {
        return "RECEPCIONISTA";
    }
}