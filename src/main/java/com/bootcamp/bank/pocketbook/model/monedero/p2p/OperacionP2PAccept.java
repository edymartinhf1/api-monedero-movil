package com.bootcamp.bank.pocketbook.model.monedero.p2p;

import lombok.Data;

@Data
public class OperacionP2PAccept {
    private String id;
    private String idClienteAceptante; // Aceptante
    private String numeroCelularAceptante;
}
