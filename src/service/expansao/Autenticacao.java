package service.expansao;


import java.util.List;

public class Autenticacao {
    private List<Usuario> usuarios;

    public Autenticacao(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario logar(String login, String senha) {
        for (Usuario u : usuarios) {
            if (u.getLogin().equals(login) && u.autenticar(senha)) {
                return u;
            }
        }
        return null;
    }
}