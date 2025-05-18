package com.puntolot.miapp;

import com.puntolot.miapp.controller.MenuController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Iniciando la aplicación de conversión de moneda...");
        MenuController menuController = new MenuController();
        menuController.start();
        logger.info("Aplicación finalizada.");
    }
}
