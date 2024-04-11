package agenda.controllers;

import java.time.LocalDate;
import agenda.models.*;


public class SessaoController {
    private UsuarioController controladorDeUsuarios;
    private Usuario usuarioLogado;

    public SessaoController(){
        this.usuarioLogado = null;
    }

    public String getUserNome(){
        return usuarioLogado.getNome();
    }

    public void setControladorDeUsuarios(UsuarioController controladorDeUsuarios){
        this.controladorDeUsuarios = controladorDeUsuarios;
    }

    public boolean logado(){
        if(usuarioLogado != null) return true;
        return false;
    }

    public void login(String email, String senha){
        if(this.usuarioLogado != null){
            System.out.println("Já existe um usuário logado!");
        } else {
            if((this.usuarioLogado = controladorDeUsuarios.logarUsuario(email, senha)) != null){
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
        this.usuarioLogado.setTelefone(telefone);
    }

    public void editarNascimento(int dia, int mes, int ano){
        this.usuarioLogado.setNascimento(LocalDate.of(ano, mes, dia));
    }

    public void editarEndereco(String rua, String cidade, String estado, String codigoPostal, String pais){
        this.usuarioLogado.setEndereco(new Endereco(rua, cidade, estado, codigoPostal, pais));
    }

    public void editarSenha(String senha){
        this.usuarioLogado.setSenha(senha);
    }

    public void criarEvento(String titulo, int dia, int mes, int ano, String hora, String descricao, String nomeLocal, String descLocal, int capacidadeLocal, Endereco enderecoLocal){
        Evento novoEvento = new Evento(titulo, LocalDate.of(ano, mes, dia), hora, descricao, new Local(nomeLocal, descLocal, capacidadeLocal, enderecoLocal));
        Agenda agenda = this.usuarioLogado.getAgenda();
        agenda.addEvento(novoEvento);
    }

    public void visualizarEventos(){
        Agenda agenda = this.usuarioLogado.getAgenda();
        agenda.exibirEventos();
    }

    public void atualizarStatusEvento(int id, String novoStatus){
        Agenda agenda = this.usuarioLogado.getAgenda();
        Evento evento = agenda.getEventoById(id);
        evento.setStatus(novoStatus);
    }

    public void convidarUsuario(String email, int eventoId, String descricao){
        Agenda agenda = this.usuarioLogado.getAgenda();
        Evento evento = agenda.getEventoById(eventoId);
        this.controladorDeUsuarios.convidarUsuario(email, evento, descricao);
    }

    public void removerEvento(int id){
        Agenda agenda = this.usuarioLogado.getAgenda();
        agenda.removerEventoById(id);
    }
}