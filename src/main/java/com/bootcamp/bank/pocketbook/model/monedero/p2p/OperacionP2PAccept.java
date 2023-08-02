package com.bootcamp.bank.pocketbook.model.monedero.p2p;

import lombok.Data;

/**
 * Clase aceptacion intercambio P2P
 */
@Data
public class OperacionP2PAccept {
    private String idInterCambio;
    private String idClienteAceptante; // Aceptante
    private String numeroCelularAceptante;
}
