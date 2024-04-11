package agenda.models;

import java.time.LocalDate;
import java.util.UUID;
import java.util.LinkedList;

public class Usuario extends Pessoa {
    private UUID id;
    private String senha;
    private Agenda agenda;
    private LinkedList<Notificacao> notificacoes;

    public Usuario(String nome, String email, String senha) {
        super(nome, email);
        this.id = UUID.randomUUID();
        this.senha = senha;
        this.agenda = new Agenda("Agenda de " + nome, "Sem descricao.");
        this.notificacoes = new LinkedList<Notificacao>();
    }

    public void addNotificacao(Notificacao novaNotificacao){
        this.notificacoes.addFirst(novaNotificacao);
    }

    public void removerNotificacaoAntiga(){
        this.notificacoes.removeLast();
    }

    public UUID getId() {
        return id;
    }

    public Agenda getAgenda(){
        return agenda;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean verificaSenha(String senha) {
        return this.senha.equals(senha);
    }
    
}