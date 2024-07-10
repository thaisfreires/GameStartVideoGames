package MenuAdmin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static MenuAdmin.contarLinhas.contadorLinhas;

public class contarLinhas {
    public static int contadorLinhas(String path) throws FileNotFoundException {

        Scanner sc = new Scanner(new File(path));

        int linhas = 0;

        while (sc.hasNextLine()){
            linhas++;
            sc.nextLine();
        }

        return linhas;
    }


    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Número de Linhas: " + contadorLinhas("GameStart/GameStart_Vendas.csv"));
    }

}
