package com.puntolot.miapp.controller;

import com.puntolot.miapp.service.CurrencyConverterService;
import com.puntolot.miapp.util.InputUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class MenuController {
    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
    private final CurrencyConverterService converterService = new CurrencyConverterService();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        boolean exit = false;
        while (!exit) {
            showMenu();
            int option = InputUtil.readInt("Selecciona una opción: ", scanner);

            switch (option) {
                case 1 -> handleConversion();
                case 2 -> {
                    logger.info("Saliendo de la aplicación.");
                    exit = true;
                }
                default -> logger.warn("Opción inválida seleccionada.");
            }
        }
    }

    private void showMenu() {
        System.out.println("""
                ==============================
                💱 Conversor de Moneda
                ==============================
                1. Convertir moneda
                2. Salir
                """);
    }



    /*private void handleConversion() {
        scanner.nextLine(); // <<--- Consumir salto pendiente
        String from = InputUtil.readLine("Moneda origen (ej: USD): ", scanner).toUpperCase();
        String to = InputUtil.readLine("Moneda destino (ej: EUR): ", scanner).toUpperCase();
        double amount = InputUtil.readDouble("Monto a convertir: ", scanner);

        double result = converterService.convert(from, to, amount);
        System.out.printf("Resultado: %.2f %s%n", result, to);
        logger.info("Conversión realizada: {} {} a {} = {}", amount, from, to, result);
    }*/
    private void handleConversion() {
        // Limpiar buffer del scanner
        scanner.nextLine();

        System.out.print("Moneda origen (ej: USD): ");
        String from = scanner.nextLine().trim().toUpperCase();

        System.out.print("Moneda destino (ej: EUR): ");
        String to = scanner.nextLine().trim().toUpperCase();

        double amount = InputUtil.readDouble("Monto a convertir: ", scanner);

        try {
            double result = converterService.convert(from, to, amount);
            System.out.printf("Resultado: %.2f %s%n", result, to);
            logger.info("Conversión realizada: {} {} a {} = {}", amount, from, to, result);
        } catch (Exception e) {
            logger.error("Error de conversión: {}", e.getMessage());
            System.out.println("⚠ No se pudo realizar la conversión.");
        }
    }

}
