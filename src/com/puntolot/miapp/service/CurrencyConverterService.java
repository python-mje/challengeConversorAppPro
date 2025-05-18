package com.puntolot.miapp.service;

import com.google.gson.Gson;
import com.puntolot.miapp.model.ExchangeRateResponse;
import com.puntolot.miapp.util.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class CurrencyConverterService {
    private static final Logger logger = LoggerFactory.getLogger(CurrencyConverterService.class);
    private final Gson gson = new Gson();

    public double convert(String from, String to, double amount) {
        logger.info("Solicitando conversión de {} a {} con monto {}", from, to, amount);

        try {
            String apiKey = Config.getApiKey();
            String endpoint = String.format("https://v6.exchangerate-api.com/v6/%s/latest/%s", apiKey, from);

            URL url = new URL(endpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            try (InputStreamReader reader = new InputStreamReader(conn.getInputStream())) {
                ExchangeRateResponse response = gson.fromJson(reader, ExchangeRateResponse.class);
                Map<String, Double> rates = response.getConversion_rates();

                if (!rates.containsKey(to)) {
                    logger.error("Moneda destino '{}' no encontrada en la API", to);
                    throw new IllegalArgumentException("Moneda destino no encontrada.");
                }

                double rate = rates.get(to);
                logger.info("Tasa de conversión {} → {} = {}", from, to, rate);
                return amount * rate;
            }

        } catch (Exception e) {
            logger.error("Error al realizar la conversión desde API: {}", e.getMessage());
            throw new RuntimeException("No se pudo obtener la tasa de cambio.");
        }
    }
}
