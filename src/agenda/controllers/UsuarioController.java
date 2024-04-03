package agenda.controllers;

import agenda.models.Usuario;
import java.util.HashMap;

public class UsuarioController {
    private HashMap<String, Usuario> usuarios;

    public UsuarioController(){
        this.usuarios = new HashMap<String, Usuario>();
    }

    public void cadastrarUsuario(String nome, String email, String senha){
        Usuario novoUsuario = new Usuario(nome, email, senha);
        this.usuarios.put(novoUsuario.getEmail(), novoUsuario)
    }

    public Usuario encontrarUsuario(String email, String senha){
        Usuario usuario;
        usuario = this.usuarios.get(email);
        if(usuario.verificaSenha(senha)) return usuario;
        return null;
    }
}

/* HashMap
 * ------------------------------
 * "email@email.com" : Usuario  |
 * "email@email.com" : Usuario  |
 * ------------------------------
 */