package Cliente;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static Admin.Funções.copyright;
import static Cliente.FuncoesCliente.*;

public class MenuCliente {
    /**
     * Método que imprime o menu do Cliente.
     *
     * @throws FileNotFoundException Caso o ficheiro não exista
     */
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
                    System.out.println("\n***** CATÁLOGO DE JOGOS *****\n");
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
                    System.out.println("\n Volte Sempre! \n\n");
                    copyright();
                    break;

                default:
                    System.out.println("⚠\uFE0F⚠\uFE0F Opção Inválida ⚠\uFE0F⚠\uFE0F");
                    break;
            }

        } while (opcao != 0);
    }
}
