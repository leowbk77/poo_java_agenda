package agenda.controllers;

import java.time.LocalDate;
import agenda.models.Usuario;
import agenda.models.Endereco;


public class SessaoController {
    private UsuarioController controladorDeUsuarios;
    private Usuario usuarioLogado;

    public SessaoController(){
        this.usuarioLogado = null;
    }

    public setControladorDeUsuarios(UsuarioController controladorDeUsuarios){
        this.controladorDeUsuarios = controladorDeUsuarios;
    }

    // talvez retornar um bool ou int e ver como fica com o menu...
    public void login(String email, String senha){
        if(this.usuarioLogado != null){
            System.out.println("Já existe um usuário logado!");
        } else {
            if((this.usuarioLogado = controladorDeUsuarios.encontrarUsuario(email, senha)) != null){
                System.out.println("Login bem sucedido!");
            } else System.out.println("Falha no login.");
        } 
    }

    public void logout(){
        if(this.usuarioLogado != null){
            this.usuarioLogado = null;
        } else System.out.println("Não há usuário logado.");
    }

    public void editarTelefone(String telefone){
        if(this.usuarioLogado != null) this.usuarioLogado.setTelefone(telefone);
    }

    public void editarNascimento(int dia, int mes, int ano){
        if(this.usuarioLogado != null) this.usuarioLogado.setNascimento(LocalDate.of(ano, mes, dia));
    }

    public void editarEndereco(String rua, String cidade, String estado, String codigoPostal, String pais){
        if(this.usuarioLogado != null) this.usuarioLogado.setEndereco(new Endereco(rua, cidade, estado, codigoPostal, pais));
    }

    public void editarSenha(String senha){
        if(this.usuarioLogado != null) this.usuarioLogado.setSenha(senha);
    }
}