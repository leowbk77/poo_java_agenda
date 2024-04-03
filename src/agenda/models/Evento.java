package agenda.models;

import java.time.LocalDate;

public class Evento {
    private String titulo;
    private LocalDate data;
    private String hora;
    private String descricao;
    private Local local;

    public Evento(String titulo, LocalDate data, String hora, String descricao, Local local){
        this.titulo = titulo;
        this.data = data;
        this.hora = hora;
        this.descricao = descricao;
        this.local = local;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public LocalDate getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public String getDescricao() {
        return descricao;
    }

    public Local getLocal(){
        return local;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setLocal(Local local) {
        this.local = local;
    }
}