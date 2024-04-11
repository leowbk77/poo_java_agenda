package agenda.models;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Set;

public class Evento {
    private String titulo;
    private LocalDate data;
    private String hora;
    private String descricao;
    private Local local;

    private boolean confirmado;
    private HashMap<String, StatusDeConvite> convidados;
    private String status;

    public Evento(String titulo, LocalDate data, String hora, String descricao, Local local){
        this.titulo = titulo;
        this.data = data;
        this.hora = hora;
        this.descricao = descricao;
        this.local = local;
        this.confirmado = false;
        this.convidados = new HashMap<String, StatusDeConvite>();
        this.status = "Indefinido";
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

    public String getStatus(){
        return status;
    }

    public Set<String> getConvidados(){
        return convidados.keySet();
    }

    public void setStatus(String status){
        this.status = status;
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

    public void exibirEvento(){
        System.out.println("EVENTO" + this.titulo);
        System.out.println("DATA: " + this.data + " HORA: " + this.hora);
        System.out.println("DESCRICAO: \n" + this.descricao);
        System.out.println("STATUS: " + this.status);
        System.out.println("LOCAL:");
        this.local.exibirLocal();
        System.out.println("===================================================================");
    }

    public void convidar(String email){
        this.convidados.put(email, new StatusDeConvite());
    }


}