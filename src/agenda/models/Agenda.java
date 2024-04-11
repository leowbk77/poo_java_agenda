package agenda.models;

import java.util.HashMap;
import java.util.Set;

public class Agenda {
    private String nome;
    private String descricao;
    private HashMap<Integer, Evento> eventos;
    private int ultimoId;

    public Agenda(String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;
        this.eventos = new HashMap<Integer, Evento>();
        this.ultimoId = 0;
    }

    public void addEvento(Evento novoEvento){
        this.ultimoId += 1;
        this.eventos.put(this.ultimoId, novoEvento);
    }

    public Evento getEventoById(int id){
        return this.eventos.get(id);
    }

    public void removerEventoById(int id){
        this.eventos.remove(id);
    }

    public String getNome(){
        return nome;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public void exibirEventos(){
        Set<Integer> ids = eventos.keySet();
        Evento evento;
        for(int id : ids){
            evento = eventos.get(id);
            System.out.println("ID: " + id);
            evento.exibirEvento();
        } 
    }
}