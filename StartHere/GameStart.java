package StartHere;

import java.io.IOException;
import java.util.Scanner;

import static Login.MenuLogin.menuLogin;

public class GameStart {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n                   --- GAMESTART STORE ---\n");
        System.out.println("    -   Seja bem vindo a loja de video games GAMESTART   -");

        menuLogin();
    }
}
