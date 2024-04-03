package agenda.models;

import java.time.LocalDate;
import java.util.UUID;

public class Usuario extends Pessoa {
    private UUID id;
    private String senha;

    public Usuario(String nome, String email, String senha) {
        super(nome, email)
        this.id = UUID.randomUUID();
        this.senha = senha;
    }

    public UUID getId() {
        return id;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean verificaSenha(String senha) {
        return this.senha.equals(senha);
    }
}