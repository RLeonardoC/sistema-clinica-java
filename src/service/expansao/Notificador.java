package service.expansao;


import model.Paciente;


public class Notificador {
    public void enviarNotificacao(Paciente p, String msg) {
        System.out.println("Notificação para " + p.getNome() + ": " + msg);
    }
}