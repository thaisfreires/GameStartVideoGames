package MenuAdmin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ColumnCounter {
    public static int columnCounter(String path) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(path));

        int count = 0;
        String row;
        int colunas = 0;

        while (sc.hasNextLine()) {
            row = sc.nextLine();
            String[] linhaDividida = row.split(";");
            colunas = linhaDividida.length;

        }
        return colunas;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Número de colunas: " + columnCounter("GameStart/GameStart_Vendas.csv"));


    }
}
