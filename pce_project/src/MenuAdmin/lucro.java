package MenuAdmin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static MenuAdmin.ColumnCounter.columnCounter;
import static MenuAdmin.ColumnCounter.main;
import static MenuAdmin.MenuAdmin.CsvConverter;
import static MenuAdmin.MenuAdmin.imprimirMatriz;
import static MenuAdmin.contarLinhas.contadorLinhas;

public class lucro {
    public static double valorLucro() throws FileNotFoundException {

        String[][] categoria = (CsvConverter("GameStart/GameStart_Categorias.csv"));
        String[][] vendas = (CsvConverter("GameStart/GameStart_Vendas.csv"));

        String categoriaJogos1, categoriaJogos2;
        double lucro=0, valorVendas, porcentagemMargem;

        for (int linhaMatriz = 0; linhaMatriz < categoria.length; linhaMatriz++) {
            categoriaJogos1 = categoria[linhaMatriz][0];
            porcentagemMargem = Double.parseDouble(categoria[linhaMatriz][1]) / 100;


            for (int linhaMatrizVendas = 0; linhaMatrizVendas < vendas.length; linhaMatrizVendas++) {
                categoriaJogos2 = vendas[linhaMatrizVendas][3];
                valorVendas = Double.parseDouble(vendas[linhaMatrizVendas][5]);


                if (categoriaJogos1.equalsIgnoreCase(categoriaJogos2)) {
                    lucro += porcentagemMargem * valorVendas;
                }
            }
        }
        return lucro;
    }
    public static void main (String[] args) throws FileNotFoundException {
        System.out.println("Lucro: " + valorLucro());
    }
}