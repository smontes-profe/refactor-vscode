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

    public double procesar(List<String> nombresProductos, List<Double> preciosProductos) {
        double subtotal = 0;

        // Sumar precios de la lista
        for (int i = 0; i < preciosProductos.size(); i++) {
            logger.log(Level.INFO, "Añadiendo producto: {0}", nombresProductos.get(i));
            subtotal = subtotal + preciosProductos.get(i);
        }

        // Lógica de descuento
        if (subtotal > UMBRAL_DESCUENTO) {
            logger.info("Descuento aplicado.");
            subtotal = subtotal - (subtotal * PORCENTAJE_DESCUENTO);
        }

        // Cálculo de impuestos
        double totalConIva = subtotal + (subtotal * PORCENTAJE_IVA);

        // Gastos de envío
        if (totalConIva < UMBRAL_ENVIO_GRATIS) {
            totalConIva = totalConIva + COSTE_ENVIO;
        }

        return totalConIva;
    }
}
