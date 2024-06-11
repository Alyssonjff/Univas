package br.edu.univas.Game;
import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static String lerEntradaDoUsuario() {
        return scanner.nextLine();
    }
}
