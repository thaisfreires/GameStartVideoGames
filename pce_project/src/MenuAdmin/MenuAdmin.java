package MenuAdmin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static MenuAdmin.ColumnCounter.columnCounter;
import static MenuAdmin.contarLinhas.contadorLinhas;

public class MenuAdmin {
    public static String[][] CsvConverter(String path) throws FileNotFoundException {

        String[][] matriz = new String[contadorLinhas(path)-1][columnCounter(path)];

        Scanner sc = new Scanner(new File(path));

        String row = sc.nextLine();

        int lineCount = 0;

        while (sc.hasNextLine()) {
            row = sc.nextLine();
            String[] splitRow = row.split(";");

            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                matriz[lineCount][coluna] = splitRow[coluna];
            }

            lineCount++;
        }
        return matriz;

    }
    public static void imprimirMatriz(String[][] matriz)throws FileNotFoundException {
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                System.out.print(matriz[linha][coluna] + "\t|\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println("*****MENU ADMIN*****");
        System.out.println();
        int opcao;

        do {
            System.out.println("<< Digite 1 para Clientes >>");
            System.out.println("<< Digite 2 para Categorias >>");
            System.out.println("<< Digite 3 para Vendas >>");
            System.out.println("<< Digite 4 para Sair >>");
            opcao = input.nextInt();
            System.out.println();

            switch (opcao) {
                case 1:
                    imprimirMatriz(CsvConverter("GameStart/GameStart_Clientes.csv"));
                    break;
                case 2:
                    imprimirMatriz(CsvConverter("GameStart/GameStart_Categorias.csv"));
                    break;
                case 3:
                    imprimirMatriz(CsvConverter("GameStart/GameStart_Vendas.csv"));
                    break;
                default:
                    break;
            }
            System.out.println();
        }while (opcao != 4);
    }
}
