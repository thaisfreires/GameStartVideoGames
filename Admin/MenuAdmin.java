package Admin;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static Admin.Funções.*;
import static Admin.Funções.imprimirPesquisa;
import static Admin.LerFicheiros.ficheiro;


public class MenuAdmin {
    /**
     * Método que imprime o menu do usuário Admin.
     *
     * @throws FileNotFoundException Caso o ficheiro não exista
     */
    public static void menuAdmin() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int opcao;
        System.out.println("\n---- A D M I N ----\n");

        do {

            System.out.println("1. Abrir Ficheiros ");
            System.out.println("2. Total de Vendas ");
            System.out.println("3. Total de Lucro ");
            System.out.println("4. Pesquisa de Clientes ");
            System.out.println("5. Jogo mais caro ");
            System.out.println("6. Melhores Clientes ");
            System.out.println("7. Pesquisar Jogo ");
            System.out.println("0. Sair");
            System.out.print("\nOpção número: \n");
            opcao = input.nextInt();
            System.out.println();

            switch (opcao) {
                case 1:
                    ficheiro();
                    break;
                case 2:
                    System.out.println("*****Total de Vendas GAME START: "+ valorVendas());
                    System.out.println("\n****Número de Vendas: " + contadorLinhas("Ficheiros/GameStart_Vendas.csv"));
                    break;
                case 3:
                    System.out.println("*****Total de Lucro GAME START: \n" + valorLucro());
                    break;
                case 4:
                    imprimirIdCliente();
                    break;
                case 5:
                    System.out.println("***** Jogo mais caro GAMESTART: "+jogoMaisCaro());
                    System.out.println("\nClientes que compraram: \n");
                    clientesJogoMaisCaro();

                    break;
                case 6:
                    melhorCliente();
                    break;
                case 7:
                    System.out.println("\nClientes que compraram esse jogo: \n");
                    imprimirPesquisa();
                    break;
                case 0:
                    break;

                default:
                    System.out.println("⚠\uFE0F⚠\uFE0F Opção Inválida ⚠\uFE0F⚠\uFE0F");
                    break;
            }
            System.out.println();
        }while (opcao != 0);
    }
    public static boolean admin() throws FileNotFoundException {

        boolean adminCorreto = false;
        System.out.println("- Você selecionou ADMIN -");
        Scanner input = new Scanner(System.in);
        System.out.println("\nUSERNAME: ");
        String username = input.next();
        System.out.println("\nPASSWORD: ");
        String password = input.next();

        if (username.equalsIgnoreCase("ADMIN") && username.equals("admin") && password.equals("!password?456")) {
            adminCorreto = true;
            menuAdmin();
        }
        while(!password.equals("!password?456")) {
            System.out.println("\n⚠\uFE0F⚠\uFE0F Wrong Password ⚠\uFE0F⚠\uFE0F\n");
            break;
        }
        return adminCorreto;
    }
}
