package com.bootcamp.bank.pocketbook.model.monedero.p2p;

import lombok.Data;

@Data
public class OperacionP2PRequest {

    private String idClienteSolicitante; //Solicita
    private String tipoIntercambioP2P; // COM = COMPRA VEN=VENTA
    private String numeroCelular;
    private String numeroCuenta;
    private String modoPago; // MON = YANKI TRA =TRANSFERENCIA
    private Double monto;
}
