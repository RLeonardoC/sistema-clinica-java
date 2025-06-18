package service.expansao;

public class Administrador extends Usuario {
    public Administrador(String nome, String login, String senha) {
        super(nome, login, senha);
    }

    public String getPerfil() {
        return "ADMIN";
    }
}