package	agenda.models;

public class Endereco {
    private String rua;
    private String cidade;
    private String estado;
    private String codigoPostal;
    private String pais;

    public Endereco(String rua, String cidade, String estado, String codigoPostal, String pais){
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
        this.codigoPostal = codigoPostal;
        this.pais = pais;
    }
    
    public String getRua() {
        return rua;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public String getPais() {
        return pais;
    }
    
    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void exibirEndereco(){
        System.out.println("RUA: " + this.rua + " CIDADE: " + this.cidade + " ESTADO: " + this.estado);
        System.out.println(this.codigoPostal + this.pais);
    }
}