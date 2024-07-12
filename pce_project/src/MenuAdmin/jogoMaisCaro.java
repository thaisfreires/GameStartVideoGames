package MenuAdmin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static MenuAdmin.cliente.idCliente;
import static MenuAdmin.cliente.imprimirIdCliente;

public class jogoMaisCaro {
    public static double jogoMaisCaro() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("GameStart/GameStart_Vendas.csv"));

        String conteudo = sc.nextLine(); // comecei da linha 1 e tirei o cabeçalho
        String[] linha;
        double valorMaior = 0;


        while (sc.hasNextLine()) {
            conteudo = sc.nextLine();
            linha = conteudo.split(";");
            double valor = Double.parseDouble(linha[5]);

                if (valor > valorMaior) {
                    valorMaior = valor;
                }
        }
        return valorMaior;

    }
    public static void clientesJogoMaisCaro() throws FileNotFoundException {
        double valorMaisCaro = jogoMaisCaro();
        Scanner sc = new Scanner(new File("GameStart/GameStart_Vendas.csv"));

        String conteudo = sc.nextLine(); // comecei da linha 1 e tirei o cabeçalho
        String[] linha;

        while (sc.hasNextLine()) {
            conteudo = sc.nextLine();
            linha = conteudo.split(";");
            double valor = Double.parseDouble(linha[5]);
                if (valor == valorMaisCaro) {
                    idCliente(Integer.parseInt(linha[1]));
                    System.out.println();
                }
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(">>> jogo mais caro: "+jogoMaisCaro());
        System.out.println();
        clientesJogoMaisCaro();
    }
}

