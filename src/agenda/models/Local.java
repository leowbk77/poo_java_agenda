package agenda.models;

public class Local {
    private String nome;
    private String descricao;
    private int capacidade;
    private Endereco endereco;

    public Local(String nome, String descricao, int capacidade, Endereco endereco){
        this.nome = nome;
        this.descricao = descricao;
        this.capacidade = capacidade;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void exibirLocal(){
        System.out.println(this.nome + "| Capacidade: " + capacidade);
        this.endereco.exibirEndereco();
    }

}