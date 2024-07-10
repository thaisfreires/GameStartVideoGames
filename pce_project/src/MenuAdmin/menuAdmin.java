package MenuAdmin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static MenuAdmin.contarLinhas.contadorLinhas;
import static MenuAdmin.contarLinhas.contadorLinhas;

public class menuAdmin {
    /**
     * Ler um ficheiro .csv para uma matriz
     *
     * @param path Caminho para o ficheiro
     * @return Matriz de Strings com o conteudo do ficheiro
     * @throws FileNotFoundException Caso o ficheiro não seja encontrado
     */
    /*public static String[][] CsvConverter(String path) throws FileNotFoundException {
        String[][] matriz = new String[contadorLinhas(path) - 1][4];

        Scanner sc = new Scanner(new File(path));

        String conteudo = sc.nextLine();

        int linhaMatriz = 0;

        while (sc.hasNextLine()) {
            conteudo = sc.nextLine();
            String[] linhaDividida = conteudo.split(",");

            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                matriz[linhaMatriz][coluna] = linhaDividida[coluna];
            }
            linhaMatriz++;
        }
        return matriz;
    }
    /**
     * Método que apresenta o copyright
     */
    //public static void copyright() {
    //  System.out.println("\uD83D\uDCBB\uD83D\uDCBB\uD83D\uDCBB Desenvolvido por: Thais Freire Soares \uD83D\uDCBB\uD83D\uDCBB\uD83D\uDCBB");
    // }
    /*public static void main(String[] args) throws FileNotFoundException {
        System.out.println("1. imprimir ficheiro em matriz");
        System.out.println(CsvConverter("GameStart/GameStart_Vendas.csv"));

    }*/
}