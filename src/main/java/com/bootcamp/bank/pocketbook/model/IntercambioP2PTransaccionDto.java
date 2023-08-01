package com.bootcamp.bank.pocketbook.model;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class IntercambioP2PTransaccionDto {
    private String id;
    private String tipoTransaccionP2P; // COM = compra  VEN= Venta
    private LocalDateTime fechaCreacion;
    private String numeroCelularAceptante;
    private String numeroCelularSolicitante;
    private String fechaCreacionT;
    private LocalDateTime fechaAceptacion;
    private String fechaAceptacionT;
    private String idTransaccion;
    private String modoPago; // YANKI TRANSFERENCIA
    private Double monto;
}
