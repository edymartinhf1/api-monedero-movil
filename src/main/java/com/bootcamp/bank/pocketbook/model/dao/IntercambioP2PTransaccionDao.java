package com.bootcamp.bank.pocketbook.model.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document("operacionP2Ptransaciones")
public class IntercambioP2PTransaccionDao {
    @Id
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
