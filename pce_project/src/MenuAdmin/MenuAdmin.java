package MenuAdmin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static MenuAdmin.Funções.*;
import static MenuAdmin.lerficheiro.consultarFicheiro;
import static MenuAdmin.Funções.imprimirPesquisa;
import static MenuAdmin.Funções.pesquisa;


public class MenuAdmin {
    /**
            * Método que imprime o conteúdo de um ficheiro na consola.
            *
 * @throws FileNotFoundException Caso o ficheiro não exista
 */
    public static void menuAdmin() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int opcao;
        System.out.println("\n---- A D M I N ----\n");

        do {

            System.out.println("1. Abrir Ficheiros ");
            System.out.println("2. Total de Vendas ");
            System.out.println("3. Total de Lucro ");
            System.out.println("4. Pesquisa de Clientes ");
            System.out.println("5. Jogo mais caro ");
            System.out.println("6. Melhores Clientes ");
            System.out.println("7. Pesquisar Jogo ");
            System.out.println("0. Sair");
            System.out.print("\nOpção número: \n");
            opcao = input.nextInt();
            System.out.println();

            switch (opcao) {
                case 1:
                    Ficheiro();
                    break;
                case 2:
                    System.out.println("*****Total de Vendas GAME START: "+ valorVendas());
                    System.out.println("\n****Número de Vendas: " + contadorLinhas("GameStart/GameStart_Vendas.csv"));
                    break;
                case 3:
                    System.out.println("*****Total de Lucro GAME START: \n" + valorLucro());
                    break;
                case 4:
                    imprimirIdCliente();
                    break;
                case 5:
                    System.out.println("***** Jogo mais caro GAMESTART: "+jogoMaisCaro());
                    System.out.println("\nClientes que compraram: \n");
                    clientesJogoMaisCaro();

                    break;
                case 6:
                    melhorCliente();
                    break;
                case 7:
                    System.out.println("\nClientes que compraram esse jogo: \n");
                    imprimirPesquisa();
                    break;
                case 0:
                    break;

                default:
                    System.out.println("⚠\uFE0F⚠\uFE0F Opção Inválida ⚠\uFE0F⚠\uFE0F");
                    break;
            }
            System.out.println();
        }while (opcao != 0);
    }
    /**
     * Método que apresenta o copyright
     */
    public static void copyright() throws FileNotFoundException {
        consultarFicheiro("GameStart/GameStart_Copyright.txt");
    }

    public static void main(String[] args) throws FileNotFoundException {
        menuAdmin();
        copyright();
    }
}
