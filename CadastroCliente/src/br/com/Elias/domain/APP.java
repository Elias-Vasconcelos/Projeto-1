package br.com.Elias.domain;

import br.com.Elias.domain.Domain.Cliente;
import br.com.Elias.domain.dao.ClientesetDAO;
import br.com.Elias.domain.dao.IClienteDAO;

import javax.swing.*;

public class APP {

    private static IClienteDAO iclaintDAO;

    public static void main (String args[]){
        iclaintDAO = new ClientesetDAO();


        String opcao = JOptionPane.showInputDialog(null, "Digite 1 para cadastrar, 2 para consutar, 3 para Exclusão, 4 para alteraçao ou 5 para sair",
                "Cadastro", JOptionPane.INFORMATION_MESSAGE);


        while (!isOpcaoValida(opcao)){
            if( "".equals(opcao) ){
               sair();
            }


         opcao = JOptionPane.showInputDialog(null, "Opcao invalida, Digite 1 para cadastrar, 2 para consutar, 3 para Exclusão, 4 para alteraçao ou 5 para sair",
                    "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        }



        while (isOpcaoValida(opcao)){
            if (isOpcaoCadstro(opcao)){
               String dados = JOptionPane.showInputDialog(null, "Digite os parametros separados por virgula: Cpf, Nome, Telefone, Endereco, Numero, Cidade, Estado",
                        "Teste", JOptionPane.INFORMATION_MESSAGE);
               cadastrar(dados);
            }
        }
    }

    private static void cadastrar(String dados) {
        String[] dadosSeparados = dados.split(",");
        Cliente novoClinete = new Cliente(dadosSeparados[0],dadosSeparados[1],dadosSeparados[2],dadosSeparados[3],dadosSeparados[4],dadosSeparados[5],dadosSeparados[6]);
        iclaintDAO.cadastrar(novoClinete);
    }


    private static void sair() {
        JOptionPane.showInputDialog(null, "Obrigado!",
                "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static boolean isOpcaoValida(String opcao) {
        if(opcao.equals("1") || opcao.equals("2") ||opcao.equals("3") ||opcao.equals("4") ||opcao.equals("5")){
            return true;
        }
        return false;
    }

    private static boolean isOpcaoCadstro(String opcao) {
        if(opcao.equals("1")){
            return true;
        }
        return false;
    }

    private static boolean isOpcaoConsutar(String opcao) {
        if(opcao.equals("2")){
            return true;
        }
        return false;
    }

    private static boolean isOpcaoExcluir(String opcao) {
        if(opcao.equals("3")){
            return true;
        }
        return false;
    }

    private static boolean isOpcaoAltercao(String opcao) {
        if(opcao.equals("4")){
            return true;
        }
        return false;
    }

    private static boolean isOpcaoSair(String opcao) {
        if(opcao.equals("5")){
            return true;
        }
        return false;
    }
}
