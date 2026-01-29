package com.ilerna.pruebas;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;

/**
 * Código inicial para la práctica de refactorización.
 * Criterios: Nombres genéricos, números mágicos y métodos con demasiadas
 * responsabilidades.
 */
public class ProcesadorPedidos {
    private static final Logger logger = Logger.getLogger(ProcesadorPedidos.class.getName());

    private static final double PORCENTAJE_DESCUENTO = 0.10;
    private static final double PORCENTAJE_IVA = 0.21;
    private static final double COSTE_ENVIO = 15.95;
    private static final double UMBRAL_DESCUENTO = 100.0;
    private static final double UMBRAL_ENVIO_GRATIS = 500.0;

    public double procesar(List<String> a, List<Double> b) {
        double t = 0;

        // Sumar precios de la lista
        for (int i = 0; i < b.size(); i++) {
            logger.log(Level.INFO, "Añadiendo producto: {0}", a.get(i));
            t = t + b.get(i);
        }

        // Lógica de descuento (Magic Number 100 y 0.10)
        if (t > UMBRAL_DESCUENTO) {
            logger.info("Descuento aplicado.");
            t = t - (t * PORCENTAJE_DESCUENTO);
        }

        // Cálculo de impuestos (Magic Number 0.21)
        double res = t + (t * PORCENTAJE_IVA);

        // Gastos de envío (Magic Number 500 y 15.95)
        if (res < UMBRAL_ENVIO_GRATIS) {
            res = res + COSTE_ENVIO;
        }

        return res;
    }
}
