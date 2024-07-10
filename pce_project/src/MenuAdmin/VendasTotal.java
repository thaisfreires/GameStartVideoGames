package MenuAdmin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VendasTotal {
    public static double valorVendas() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/GameStart/GameStart/GameStart_Vendas.csv"));
        double total = 0;
        String linha = sc.nextLine();


        while (sc.hasNextLine()) {
            linha = sc.nextLine();
            String[] linhaDividida = linha.split(";");
            total += Double.parseDouble(linhaDividida[5]);

        }
        return total;

    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Total de Vendas: "+ valorVendas());
        //adicionar contador de linhas
    }
}
