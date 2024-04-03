package agenda.models;

import java.time.LocalDate;

abstract class Pessoa {
    protected String nome;
    protected String email;
    protected String telefone;
    protected LocalDate nascimento;
    protected Endereco endereco;

    public Pessoa(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.telefone = "";
        this.nascimento = null;
        this.endereco = null;
    }
    
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}