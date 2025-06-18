package sistema.expansao;

public abstract class Usuario {
    protected String nome;
    protected String login;
    protected String senha;

    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public String getNome() { return nome; }
    public String getLogin() { return login; }

    public boolean autenticar(String senha) {
        return this.senha.equals(senha);
    }

    public abstract String getPerfil();
}