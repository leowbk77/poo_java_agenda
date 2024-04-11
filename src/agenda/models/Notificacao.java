package agenda.models;

public class Notificacao {
    private String tipo;
    private String mensagem;

    public Notificacao(String tipo, String mensagem){
        this.tipo = tipo;
        this.mensagem = mensagem;
    }

    public String getTipo(){
        return tipo;
    }

    public String getMensagem(){
        return mensagem;
    }
}