package Login;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static Admin.Funções.copyright;
import static Admin.MenuAdmin.admin;
import static Cliente.MenuCliente.menuCliente;

public class MenuLogin {
    /**
     * Método que gerencia o login do usuário.
     *
     * @throws FileNotFoundException Caso o ficheiro não exista
     * @throws IOException Caso exista algum tipo de exceção
     */
    public static void menuLogin() throws FileNotFoundException, IOException{
        Scanner input = new Scanner(System.in);

        System.out.println("\nTIPO DE UTILIZADOR: \n");
        int utilizador;

        do {

            System.out.println("1. ADMIN ");
            System.out.println("2. CLIENTE ");
            System.out.println("0. Sair");
            System.out.print("\nOpção número: ");
            utilizador = input.nextInt();
            System.out.println();

            switch (utilizador) {
                case 1:
                    admin();
                    break;
                case 2:
                    menuCliente();
                    break;
                case 0:
                    System.out.println("\n Volte Sempre! \n\n");
                    copyright();
                    break;
                default:
                    System.out.println("⚠\uFE0F⚠\uFE0F Opção Inválida ⚠\uFE0F⚠\uFE0F");
                    break;
            }

        } while (utilizador != 0);
    }

}