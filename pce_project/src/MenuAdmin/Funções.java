package MenuAdmin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static MenuCliente.FuncoesCliente.copyright;


public class Funções {
    /**
     * Método que converte um arquivo CSV em matriz.
     */
    public static String[][] CsvConverter(String path) throws FileNotFoundException {
        String[][] matriz = new String[contadorLinhas(path)-1][columnCounter(path)];
        Scanner sc = new Scanner(new File(path));
        String linha = sc.nextLine();
        int contadorLinha = 0;

        while (sc.hasNextLine()) {
            linha = sc.nextLine();
            String[] linhaDividida = linha.split(";");

            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                matriz[contadorLinha][coluna] = linhaDividida[coluna];
            }
            contadorLinha++;
        }
        return matriz;
    }
    /**
     * Método para imprimir um ficheiro em formato matriz/tabela.
     */
    public static void imprimirMatriz(String[][] matriz)throws FileNotFoundException {
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                System.out.print(matriz[linha][coluna] + "\t|\t");
            }
            System.out.println();
        }
    }
    /**
     * Método que apresenta opções de ficheiros a serem impressos na consola..
     */
    public static void Ficheiro() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int opcao;

        do {

            System.out.println("<< 1 para CLIENTES >>");
            System.out.println("<< 2 para CATEGORIAS >>");
            System.out.println("<< 3 para VENDAS >>");
            System.out.println("<< 4 para SAIR >>");
            System.out.println("***** Qual Ficheiro deseja abrir? ");
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
                    copyright();
                    break;
            }
            System.out.println();
        }while (opcao != 4);
    }
    /**
     * Método que calcula o número de colunas de um ficheiro.
     */
    public static int columnCounter(String path) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(path));

        String row;
        int colunas = 0;

        while (sc.hasNextLine()) {
            row = sc.nextLine();
            String[] linhaDividida = row.split(";");
            colunas = linhaDividida.length;

        }
        return colunas;
    }
    /**
     * Método que calcula o número de linhas do ficheiro.
     */
    public static int contadorLinhas(String path) throws FileNotFoundException {

        Scanner sc = new Scanner(new File(path));

        int linhas = 0;

        while (sc.hasNextLine()){
            linhas++;
            sc.nextLine();
        }

        return linhas;
    }
    /**
     * Método que calcula e imprime o total de vendas e o valor total.
     */
    public static double valorVendas() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("GameStart/GameStart_Vendas.csv"));
        double total = 0;
        String linha = sc.nextLine();


        while (sc.hasNextLine()) {
            linha = sc.nextLine();
            String[] linhaDividida = linha.split(";");
            total += Double.parseDouble(linhaDividida[5]);

        }
        return total;

    }
    /**
     * Método que calcula e imprime o valor total dos lucros lendo dois ficheiros.
     */
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
    /**
     * Método que imprime todas as informações de um cliente dado o seu ID.
     *
     * @param num Identificador único do cliente
     */
    public static void idCliente(int num) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("GameStart/GameStart_Clientes.csv"));

        String conteudo = sc.nextLine();
        String[] linha;
        int id = 0;

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
    /**
     * Método que imprime todas as informações de um cliente dado o seu ID.
     *
     */
    public static void imprimirIdCliente() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        Scanner sc = new Scanner(new File("GameStart/GameStart_Clientes.csv"));
        System.out.print("ID CLIENTE: ");
        int id = input.nextInt();
        idCliente(id);
    }
    /**
     * Método que imprime o jogo mais caro.
     */
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
                 int num = Integer.parseInt(linha[1]);
                 idCliente(num);
                System.out.println();
            }
        }
    }
    public static double melhorCliente() throws FileNotFoundException {
        String[][] clientes = (CsvConverter("GameStart/GameStart_Clientes.csv"));
        String[][] vendas = (CsvConverter("GameStart/GameStart_Vendas.csv"));

        double total = 0, valorMaior=0;
        String id, idValorGasto;


        for (int linhaMatrizClientes = 0; linhaMatrizClientes < clientes.length; linhaMatrizClientes++) {
            id = clientes[linhaMatrizClientes][0];
            String nome = clientes[linhaMatrizClientes][1];
            String telemovel = clientes[linhaMatrizClientes][2];
            String email = clientes[linhaMatrizClientes][3];
            double valorGasto=0;


            for (int linhaMatrizVendas = 0; linhaMatrizVendas < vendas.length; linhaMatrizVendas++) {
                idValorGasto = vendas[linhaMatrizVendas][1];

                if (id.equals(idValorGasto)){
                    valorGasto+=Double.parseDouble(vendas[linhaMatrizVendas][5]);
                }
            }
            if (valorGasto > total) {
                System.out.println("\n----- Melhor Cliente -----\n");
                System.out.println("ID Cliente: "+ id+ " || Nome: " +nome+ " || Telemóvel: "+telemovel+" || Email: "+email);
            }
            total += valorGasto;
        }
        return valorMaior;
    }

}
