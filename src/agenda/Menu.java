package agenda;

import agenda.models.*;
import agenda.controllers.*;
import java.util.Scanner;

public class Menu {

    private SessaoController controladorDeSessao;
    private UsuarioController controladorDeUsuarios;

    private String email;
    private String senha;

    private Scanner menuScanner;

    public Menu(){
        this.controladorDeSessao = new SessaoController();
        this.controladorDeUsuarios = new UsuarioController();
        this.controladorDeSessao.setControladorDeUsuarios(controladorDeUsuarios);
        this.menuScanner = new Scanner(System.in);
    }

    public void menu(){
        while(true){
            if(controladorDeSessao.logado()){
                switch(menuUsuario()){
                    case 1:
                        editarInfos();
                        break;
                    case 2:
                        criarEvento();
                        break;
                    case 3:
                        controladorDeSessao.visualizarEventos();
                        break;
                    case 4:
                        editarEventos();
                        break;
                    case 5:
                        controladorDeSessao.logout();
                        break;
                    default:
                        System.out.println("Opção invalida.");
                        break;
                }
            } else {
                switch(bemVindo()){
                    case 1:
                        cadastro();
                        break;
                    case 2:
                        login();
                        break;
                    default:
                        System.out.println("Opção invalida.");
                        break;
                }
            }
        }
    }

    public int bemVindo(){
        System.out.println("INICIO");
        System.out.println("[1] - Criar novo usuário");
        System.out.println("[2] - Fazer login");
        return menuScanner.nextInt();
    }

    public void cadastro(){
        String nome;
        String email;
        String senha;
        System.out.println("CADASTRO");
        System.out.println("Nome:");
        nome = menuScanner.nextLine();
        System.out.println("email:");
        email = menuScanner.nextLine();
        System.out.println("senha:");
        senha = menuScanner.nextLine();
        this.controladorDeUsuarios.cadastrarUsuario(nome, email, senha);
    }

    public void login(){
        System.out.println("LOGIN");
        System.out.print("Email: ");
        email = menuScanner.nextLine();
        System.out.print("\nSenha: ");
        senha = menuScanner.nextLine();
        System.out.println("Realizando cadastro: " + email);
        this.controladorDeSessao.login(email, senha);
    }

    public int menuUsuario(){
        System.out.println("Bem vindo, " + controladorDeSessao.getUserNome());
        System.out.println("[1] - Editar informações");
        System.out.println("[2] - Criar evento");
        System.out.println("[3] - Visualizar eventos");
        System.out.println("[4] - Editar eventos");
        System.out.println("[5] - logout");
        return menuScanner.nextInt();
    }

    public void editarInfos(){
        int op, dia, mes, ano;
        String telefone, rua, cidade, estado, codPostal, pais, senha;
        System.out.println("[1] - Editar telefone");
        System.out.println("[2] - Editar nascimento");
        System.out.println("[3] - Editar endereco");
        System.out.println("[4] - Editar senha");
        switch(menuScanner.nextInt()){
            case 1:
                System.out.println("Novo telefone:");
                telefone = menuScanner.nextLine();
                this.controladorDeSessao.editarTelefone(telefone);
                break;
            case 2:
                System.out.println("Nova data:");
                System.out.println("Dia:");
                dia = menuScanner.nextInt();
                System.out.println("Mes:");
                mes =  menuScanner.nextInt();
                System.out.println("Ano:");
                ano =  menuScanner.nextInt();
                this.controladorDeSessao.editarNascimento(dia, mes, ano);
                break;
            case 3:
                System.out.println("Novo endereço");
                System.out.println("Rua:");
                rua =  menuScanner.nextLine();
                System.out.println("Cidade:");
                cidade =  menuScanner.nextLine();
                System.out.println("Estado:");
                estado =  menuScanner.nextLine();
                System.out.println("Codigo Postal:");
                codPostal =  menuScanner.nextLine();
                System.out.println("País:");
                pais =  menuScanner.nextLine();
                this.controladorDeSessao.editarEndereco(rua, cidade, estado, codPostal, pais);
                break;
            case 4:
                System.out.println("Nova senha");
                senha =  menuScanner.nextLine();
                this.controladorDeSessao.editarSenha(senha);
                break;
            default:
                System.out.println("Nenhuma opcao selecionada.");
                break;
        }
    }

    public void editarEventos(){
        int idEvento;
        String email, descricao;
        System.out.println("[1] - Atualizar status de um evento");
        System.out.println("[2] - Convidar usuarios para um evento");
        System.out.println("[3] - Remover um evento");
        switch(menuScanner.nextInt()){
            case 1:
                System.out.println("ID do evento:");
                idEvento = menuScanner.nextInt();
                System.out.println("Novo status:");
                email = menuScanner.nextLine();
                this.controladorDeSessao.atualizarStatusEvento(idEvento, email);
                break;
            case 2:
                System.out.println("ID do evento:");
                idEvento = menuScanner.nextInt();
                System.out.println("Email do convidado:");
                email = menuScanner.nextLine();
                System.out.println("Descricao:");
                descricao = menuScanner.nextLine();
                this.controladorDeSessao.convidarUsuario(email, idEvento, descricao);
                break;
            case 3:
                System.out.println("ID do evento:");
                idEvento = menuScanner.nextInt();
                this.controladorDeSessao.removerEvento(idEvento);
                break;
            default:
                System.out.println("Nenhuma opcao selecionada.");
                break;
        }
    }

    public void criarEvento(){
        System.out.println("NOVO EVENTO");
        System.out.println("Titulo:");
        String titulo = menuScanner.nextLine();
        System.out.println("Dia:");
        int dia = menuScanner.nextInt();
        System.out.println("Mes:");
        int mes =  menuScanner.nextInt();
        System.out.println("Ano:");
        int ano =  menuScanner.nextInt();
        System.out.println("Hora:");
        String hora =  menuScanner.nextLine();
        System.out.println("Descricao:");
        String descricaoEvento =  menuScanner.nextLine();
        System.out.println("LOCAL");
        System.out.println("Nome:");
        String nomeLocal =  menuScanner.nextLine();
        System.out.println("Descricao:");
        String descLocal =  menuScanner.nextLine();
        System.out.println("Capacidade:");
        int capacidade =  menuScanner.nextInt();
        System.out.println("ENDEREÇO");
        System.out.println("Rua:");
        String rua =  menuScanner.nextLine();
        System.out.println("Cidade:");
        String cidade =  menuScanner.nextLine();
        System.out.println("Estado:");
        String estado =  menuScanner.nextLine();
        System.out.println("Codigo Postal:");
        String codPostal =  menuScanner.nextLine();
        System.out.println("País:");
        String pais =  menuScanner.nextLine();

        Endereco enderecoLocal = new Endereco(rua, cidade, estado, codPostal, pais);
        this.controladorDeSessao.criarEvento(titulo, dia, mes, ano, hora, descricaoEvento, nomeLocal, descLocal,capacidade, enderecoLocal);
        System.out.println("Evento adicionado a agenda.");
    }
}