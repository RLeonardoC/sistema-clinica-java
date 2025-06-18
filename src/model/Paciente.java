package model;

import service.expansao.Prontuario;

public class Paciente {
    private String nome;
    private String cpf;
    private Prontuario prontuario;

    public Paciente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.prontuario = new Prontuario();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }
}
