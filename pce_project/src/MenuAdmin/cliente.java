package MenuAdmin;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Scanner;

import static MenuAdmin.MenuAdmin.CsvConverter;

public class cliente {
    public static void idCliente(int num) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("GameStart/GameStart_Clientes.csv"));

        String conteudo = sc.nextLine();
        String[] linha;
        int id;

        while (sc.hasNextLine()) {
            conteudo = sc.nextLine();
            linha = conteudo.split(";");

            for (int i = 0; i < linha.length; i++) {
                id = Integer.parseInt(linha[0]);
                if (id == num) {
                    System.out.print(linha[i]+ "\t|\t");
                }
            }
        }
    }

    public static void imprimirIdCliente() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        Scanner sc = new Scanner(new File("GameStart/GameStart_Clientes.csv"));
        System.out.print("ID CLIENTE: ");
        int num = input.nextInt();
        idCliente(num);
    }


    public static void main(String[] args) throws FileNotFoundException {
        imprimirIdCliente();
    }
}