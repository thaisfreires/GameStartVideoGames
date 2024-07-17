package MenuCliente;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

import static MenuAdmin.MenuAdmin.menuAdmin;
import static MenuCliente.FuncoesCliente.Registro.adicionarCliente;
import static MenuCliente.FuncoesCliente.menuCliente;

public class MenuLogin {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        Scanner input = new Scanner(System.in);
        String password;


        System.out.println("\nTIPO DE UTILIZADOR ( ADMIN || CLIENTE || REGISTRO): ");
        String utilizador = input.next();

        if (utilizador.equalsIgnoreCase("CLIENTE")) {
            menuCliente();
        }
        if (utilizador.equalsIgnoreCase("REGISTRO")) {
            adicionarCliente();
        }

        System.out.println("\nUSERMAME: ");
        String username = input.next();
        System.out.println("\nPASSWORD: ");
        password = input.next();

        if (utilizador.equalsIgnoreCase("ADMIN") && username.equals("admin") && password.equals("!password?456")) {
            menuAdmin();
        }
        if (!password.equals("!password?456")) {
            System.out.println("⚠\uFE0F⚠\uFE0F Wrong Password ⚠\uFE0F⚠\uFE0F");
        }

    }
}