package MenuAdmin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static MenuAdmin.Funções.CsvConverter;
import static MenuAdmin.Funções.idCliente;

public class pesquisaVendas {
    public static void pesquisa(String nomeJogo) throws FileNotFoundException {
        String[][] clientes = (CsvConverter("GameStart/GameStart_Clientes.csv"));
        String[][] vendas = (CsvConverter("GameStart/GameStart_Vendas.csv"));
        Scanner input = new Scanner(System.in);
        System.out.println(">> Digite o jogo que deseja pesquisar: ");
        nomeJogo= input.next();

        String id, jogo, idCliente;


        for (int linhaMatrizClientes = 0; linhaMatrizClientes < clientes.length; linhaMatrizClientes++) {
            id = clientes[linhaMatrizClientes][0];
            String nome = clientes[linhaMatrizClientes][1];
            String telemovel = clientes[linhaMatrizClientes][2];
            String email = clientes[linhaMatrizClientes][3];


            for (int linhaMatrizVendas = 0; linhaMatrizVendas < vendas.length; linhaMatrizVendas++) {
                idCliente = vendas[linhaMatrizVendas][1];
                jogo = vendas[linhaMatrizVendas][4];

                if (nomeJogo.equals(jogo)) {
                    System.out.println("\n----- Clientes que compraram esse jogo -----\n");
                    System.out.println("ID Cliente: " + id + " || Nome: " + nome + " || Telemóvel: " + telemovel + " || Email: " + email);
                }
            }
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        pesquisa("FIFA 21");
    }
}


