package com.puntolot.miapp.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtil {

    public static int readInt(String prompt, Scanner scanner) {
        while (true) {
            try {
                System.out.print(prompt);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next();
            }
        }
    }

    public static double readDouble(String prompt, Scanner scanner) {
        while (true) {
            try {
                System.out.print(prompt);
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un monto válido.");
                scanner.next();
            }
        }
    }

    public static String readLine(String prompt, Scanner scanner) {
        System.out.print(prompt);
        scanner.nextLine(); // limpiar salto pendiente
        return scanner.nextLine();
    }
}
