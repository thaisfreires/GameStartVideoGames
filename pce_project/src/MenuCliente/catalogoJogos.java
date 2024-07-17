package MenuCliente;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static MenuAdmin.Funções.CsvConverter;

public class catalogoJogos {

    public static String[] jogos() throws FileNotFoundException {
        String[][] vendas = (CsvConverter("GameStart/GameStart_Vendas.csv"));
        String[] jogosNaoDuplicados = new String[vendas.length];

        String jogoAtual;
        int index=0;

        for (int linhaMatrizVendas = 0; linhaMatrizVendas < vendas.length; linhaMatrizVendas++) {
            jogoAtual = vendas[linhaMatrizVendas][4];
            boolean jogoExiste=false;

            for (int i = 0; i < jogosNaoDuplicados.length; i++) {
                if (jogosNaoDuplicados[i]!=null && jogosNaoDuplicados[i].equals(jogoAtual)) {
                    jogoExiste=true;
                }
            }

            if(!jogoExiste){
                jogosNaoDuplicados[index]=jogoAtual;
                index++;
            }
        }
        return jogosNaoDuplicados;
        }

    public static void main(String[] args) throws FileNotFoundException {
        String[] jogosNaoDuplicados = jogos();

        for (int i = 0; i < jogosNaoDuplicados.length; i++) {
            if (jogosNaoDuplicados[i]!=null){
                System.out.println(jogosNaoDuplicados[i]);
            }
        }
    }
}
