package MenuCliente;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

import static MenuAdmin.Funções.*;
import static MenuAdmin.lerficheiro.consultarFicheiro;
import static MenuCliente.FuncoesCliente.jogos;

public class FuncoesCliente {

    public static void menuCliente() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int opcao;
        System.out.println("\n---- C L I E N T E ----\n");

        do {

            System.out.println("1. Procurar Estacionamento ");
            System.out.println("2. Imprimir Catálogo de Jogos ");
            System.out.println("3. Imprimir Catálogos Gráficos ");
            System.out.println("4. Imprimir Jogo mais recente ");
            System.out.println("0. Sair");
            System.out.print("\nOpção número: ");
            opcao = input.nextInt();
            System.out.println();

            switch (opcao) {
                case 1:
                    estacionamento();
                    break;
                case 2:
                    String[] jogosNaoDuplicados = jogos();

                    for (int i = 0; i < jogosNaoDuplicados.length; i++) {
                        if (jogosNaoDuplicados[i] != null) {
                            System.out.println(jogosNaoDuplicados[i]);
                        }
                    }
                    break;
                case 3:
                    imprimirCatalogoGrafico();
                    break;
                case 4:
                    ultimoPrimeiroJogo();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("⚠\uFE0F⚠\uFE0F Opção Inválida ⚠\uFE0F⚠\uFE0F");
                    break;
            }
            System.out.println();
        } while (opcao != 0);
    }
    /**
     * Método que imprime os lugares de estacionamento vagos (números triangulares múltiplos de 5).
     */
    public static boolean estacionamento() throws FileNotFoundException {
        int triangulares = 0;
        int limite = 121;
        boolean triangular = true;

        for (int i = 1; triangulares < limite; i++) {

            triangulares = triangulares + i;
            if (triangulares % 5 == 0 && triangulares <= limite) {
                return true;
            }

            System.out.println("***** Estacionamento *****\nVaga disponível: \n" + triangulares);
        }
        return false;
    }
    /**
     * Método que imprime todos os títulos de jogos sem duplicados.
     */
    public static String[] jogos() throws FileNotFoundException {
        String[][] vendas = (CsvConverter("GameStart/GameStart_Vendas.csv"));
        String[] jogosNaoDuplicados = new String[vendas.length];

        String jogoAtual;
        int index = 0;

        for (int linhaMatrizVendas = 0; linhaMatrizVendas < vendas.length; linhaMatrizVendas++) {
            jogoAtual = vendas[linhaMatrizVendas][4];
            boolean jogoExiste = false;

            for (int i = 0; i < jogosNaoDuplicados.length; i++) {
                if (jogosNaoDuplicados[i] != null && jogosNaoDuplicados[i].equals(jogoAtual)) {
                    jogoExiste = true;
                }
            }

            if (!jogoExiste) {
                jogosNaoDuplicados[index] = jogoAtual;
                index++;
            }
        }
        return jogosNaoDuplicados;
    }
    /**
     * Método que imprime o conteúdo do ficheiro de um jogo com arte gráfica.
     *
     */
    public static void imprimirCatalogoGrafico() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println("\n***** CATÁLOGO GRÁFICO DE JOGOS *****\n");
        int opcao;

        do {
            System.out.println("<< 1. CALL OF DUTY >>");
            System.out.println("<< 2. FIFA >>");
            System.out.println("<< 3. HOLLOW KNIGHT >>");
            System.out.println("<< 4. MINECRAFT >>");
            System.out.println("<< 5. MORTAL KOMBAT >>");
            System.out.println("<< 6. OVERCOOKED >>");
            System.out.println("<< 7. WITCHER 3 >>");
            System.out.println("<< 8. SAIR >>");

            System.out.println("<< Catálogo Gráfico escolhido:  ");

            opcao = input.nextInt();
            System.out.println();

            switch (opcao) {
                case 1:
                    consultarFicheiro("GameStart/CatalogoGrafico/callOfDuty.txt");
                    break;
                case 2:
                    consultarFicheiro("GameStart/CatalogoGrafico/fifa.txt");
                    break;
                case 3:
                    consultarFicheiro("GameStart/CatalogoGrafico/hollowKnight.txt");
                    break;
                case 4:
                    consultarFicheiro("GameStart/CatalogoGrafico/minecraft.txt");
                    break;
                case 5:
                    consultarFicheiro("GameStart/CatalogoGrafico/mortalKombat.txt");
                    break;
                case 6:
                    consultarFicheiro("GameStart/CatalogoGrafico/overcooked.txt");
                    break;
                case 7:
                    consultarFicheiro("GameStart/CatalogoGrafico/witcher3.txt");
                    break;
                case 8:
                    break;
                default:
                    break;
            }
            System.out.println();
        } while (opcao != 8);
    }

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

    public static void ultimoPrimeiroJogo() throws FileNotFoundException {
        String[] jogosNaoDuplicados = jogos();
        int ultimoIndex = 0;

        for (int i = 0; i < jogosNaoDuplicados.length; i++) {
            if (jogosNaoDuplicados[i] != null) {
            }
        }
        System.out.println("*****Último Jogo pela primeira vez: " + jogosNaoDuplicados[80]);
    }
    /**
     * Método que apresenta o copyright
     */
    public static void copyright() throws FileNotFoundException {
        consultarFicheiro("GameStart/GameStart_Copyright.txt");
    }
    /**
     * Método que adiciona um novo cliente ao arquivo CSV.
     *
     * @throws FileNotFoundException Caso o arquivo não possa ser encontrado
     */

    public static void adicionarCliente() throws FileNotFoundException, IOException {
        Scanner input = new Scanner(System.in);

        System.out.println("---Novo Registro---");
        System.out.println("Nome: ");
        String nome = input.next();
        System.out.println("Telemóvel: ");
        String telemovel = input.next();
        System.out.println("Email: ");
        String email = input.next();
        String registro = nome + ";" + telemovel + ";" + email;

        FileWriter registrar = new FileWriter(new File("GameStart/GameStart_Clientes.csv"), true);

        registrar.append("\n" + registro);

        registrar.close();
        System.out.println("Registro adicionado com sucesso!"+registro);
    }


    public static void main(String[] args) throws FileNotFoundException {
        menuCliente();
        copyright();
    }
}




