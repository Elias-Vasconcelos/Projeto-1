package br.com.Elias.domain;

import br.com.Elias.domain.Domain.Cliente;
import br.com.Elias.domain.dao.ClientesetDAO;
import br.com.Elias.domain.dao.IClienteDAO;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

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

            } else if (isOpcaoConsutar(opcao)) {
                String dados = JOptionPane.showInputDialog(null, "Digite o Cpf do Cliente que voce deseja consutar",
                        "Teste", JOptionPane.INFORMATION_MESSAGE);
                consutar(dados);

            } else if (isOpcaoExcluir(opcao)) {
                excluir(opcao);

            } else if (isOpcaoAltercao(opcao)) {
                String dados = JOptionPane.showInputDialog(null, "Digite o Cpf Do Cliente que voce deseja alterar as informaçoes",
                        "Teste", JOptionPane.INFORMATION_MESSAGE);
                alterar(dados);

            } else if (isOpcaoSair(opcao)) {
                sair();
            }

             opcao = JOptionPane.showInputDialog(null, "Digite 1 para cadastrar, 2 para consutar, 3 para Exclusão, 4 para alteraçao ou 5 para sair",
                    "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        }


    }

    private static void alterar(String dados){
        Cliente cliente = iclaintDAO.consutar(Long.parseLong(dados));
        if( cliente != null ){
             String clienteSelecionado = JOptionPane.showInputDialog(null, "Digite as novas informaçoes separados por virgula: Nome, Telefone, Endereco, Numero, Cidade, Estado",
                    "Alteraçao", JOptionPane.INFORMATION_MESSAGE);

            String[] dadosSeparados = clienteSelecionado.split(",")  ;
            List<String> dadosFiltrados =  new ArrayList<>() ;


            for (String dado : dadosSeparados){
                dadosFiltrados.add(dado);
            }

            if(dadosFiltrados.size() < 6 ){
                Integer dadosVazios = ( 6 - dadosFiltrados.size());

                for(int i = 0; i < dadosVazios; i++){
                    dadosFiltrados.add("");
                }
            }


            Cliente novasInforcoes = new Cliente( dados , dadosFiltrados.get(0), dadosFiltrados.get(1), dadosFiltrados.get(2), dadosFiltrados.get(3), dadosFiltrados.get(4), dadosFiltrados.get(5));
            iclaintDAO.alterar(novasInforcoes);


            JOptionPane.showMessageDialog(null, "Alteracao feita com sucesso",
                    "Consuta", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "Não foi encontradoi nenhum cliente com este cpf",
                    "Consuta", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void excluir(String dados) {
        Cliente cliente = iclaintDAO.consutar(Long.parseLong(dados));
        if( cliente != null ){
            iclaintDAO.excluir(Long.parseLong(dados));
            JOptionPane.showMessageDialog(null, "O Cliente " + cliente.getNome() + " " + "foi Excluido com sucesso!",
                    "Consuta", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Não foi encontradoi nenhum cliente com este cpf",
                    "Consuta", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void cadastrar(String dados) {

        String[] dadosSeparados = dados.split(",")  ;
        List<String> dadosFiltrados =  new ArrayList<>() ;

        for (String dado : dadosSeparados){
            dadosFiltrados.add(dado);
        }

        if(dadosFiltrados.size() < 7 ){
            Integer dadosVazios = ( 7 - dadosFiltrados.size());

            for(int i = 0; i < dadosVazios; i++){
                dadosFiltrados.add("");
            }
        }

        Cliente novoClinete = new Cliente(dadosFiltrados.get(0), dadosFiltrados.get(1), dadosFiltrados.get(2), dadosFiltrados.get(3), dadosFiltrados.get(4), dadosFiltrados.get(5), dadosFiltrados.get(6));
        Boolean cadastrado = iclaintDAO.cadastrar(novoClinete);

        if(cadastrado) {
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!",
                    "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(null, "este Cliente ja foi cadastrado anteriormente!",
                    "Erro", JOptionPane.INFORMATION_MESSAGE);
        }


    }

    private static void consutar(String dados){
       Cliente cliente = iclaintDAO.consutar(Long.parseLong(dados));
        if( cliente != null ){
        JOptionPane.showMessageDialog(null, "O Cliente " + cliente.getNome() + " " + "foi encontrado com sucesso!",
                "Consuta", JOptionPane.INFORMATION_MESSAGE);
        } else {
        JOptionPane.showMessageDialog(null, "Não foi encontradoi nenhum cliente com este cpf",
                "Consuta", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "Obrigado!",
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
