package sistema.expansao;

public class MedicoUsuario extends Usuario {
    public MedicoUsuario(String nome, String login, String senha) {
        super(nome, login, senha);
    }

    public String getPerfil() {
        return "MEDICO";
    }
}