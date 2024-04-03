package agenda.models;

import java.util.LinkedList;

public class Agenda {
    private String nome;
    private String descricao;
    private LinkedList<Evento> eventos;

    public Agenda(String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;
        this.eventos = new LinkedList<Evento>();
    }

    public void addEvento(Evento evento) {
        eventos.add(evento);
    }

    public String getNome(){
        return nome;
    }

    public String descricao(){
        return descricao;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
}