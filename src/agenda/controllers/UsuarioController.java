package agenda.controllers;

import agenda.models.*;
import java.util.HashMap;

public class UsuarioController {
    //              EMAIL : USUARIO
    private HashMap<String, Usuario> usuarios;

    public UsuarioController(){
        this.usuarios = new HashMap<String, Usuario>();
    }

    public void cadastrarUsuario(String nome, String email, String senha){
        Usuario novoUsuario = new Usuario(nome, email, senha);
        this.usuarios.put(novoUsuario.getEmail(), novoUsuario);
    }

    public Usuario logarUsuario(String email, String senha){
        Usuario usuario = this.usuarios.get(email);
        if(usuario != null){
            if(usuario.verificaSenha(senha)) return usuario;
        }
        return null;
    }

    public void convidarUsuario(String email, Evento evento, String descricao){
        Usuario convidado = this.usuarios.get(email);
        if(convidado != null){
            Agenda agendaDoConvidado = convidado.getAgenda();
            agendaDoConvidado.addEvento(evento);
            convidado.addNotificacao(new Notificacao("Convite", descricao));
        }
    }

}

/* HashMap
 * ------------------------------
 * "email@email.com" : Usuario  |
 * "email@email.com" : Usuario  |
 * ------------------------------
 */