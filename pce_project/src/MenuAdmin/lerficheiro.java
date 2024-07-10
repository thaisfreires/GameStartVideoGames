package MenuAdmin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class lerficheiro {


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


    public static void main(String[] args) throws FileNotFoundException {
        consultarFicheiro("GameStart/GameStart_Clientes.csv");

    }
}

