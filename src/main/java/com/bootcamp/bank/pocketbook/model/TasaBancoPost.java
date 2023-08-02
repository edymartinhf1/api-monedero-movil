package com.bootcamp.bank.pocketbook.model;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TasaBancoPost {
    private String id;
    private String tipoTasa; // COM = Tasa de compra , VEN =Tasa de Venta
    private String fechaTasaT;
    private LocalDateTime fechaTasa;
    private LocalDateTime fechaCreacion;
    private String fechaCreacionT;
    private Double tipoCambio;


}
