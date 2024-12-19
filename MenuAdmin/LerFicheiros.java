package MenuAdmin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static MenuAdmin.Funções.*;

public class LerFicheiros {
    /**
     * Método que imprime o conteudo de um ficheiro na consola
     *
     * @param path Caminho para o ficheiro
     * @throws FileNotFoundException Caso o ficheiro não exista
     */
    public static void consultarFicheiro(String path) throws FileNotFoundException {

        Scanner sc = new Scanner(new File(path));

        while (sc.hasNext()) {
            String linhaAtual = sc.nextLine();
            System.out.println(linhaAtual);
        }
    }
    /**
     * Método que apresenta opções de ficheiros a serem impressos na consola..
     */
    public static void ficheiro() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int opcao;

        do {

            System.out.println("<< 1 para CLIENTES >>");
            System.out.println("<< 2 para CATEGORIAS >>");
            System.out.println("<< 3 para VENDAS >>");
            System.out.println("<< 4 para SAIR >>");
            System.out.println("***** Qual Ficheiro deseja abrir? ");
            opcao = input.nextInt();
            System.out.println();

            switch (opcao) {
                case 1:
                    imprimirMatriz(CsvConverter("Ficheiros/GameStart_Clientes.csv"));
                    break;
                case 2:
                    imprimirMatriz(CsvConverter("Ficheiros/GameStart_Categorias.csv"));
                    break;
                case 3:
                    imprimirMatriz(CsvConverter("Ficheiros/GameStart_Vendas.csv"));
                    break;
                default:
                    copyright();
                    break;
            }
            System.out.println();
        }while (opcao != 4);
    }

}
