package com.bootcamp.bank.pocketbook.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Clase Tasa Banco dto
 */
@Data
public class TasaBancoDto {
    private String id;
    private String tipoTasa;
    private LocalDateTime fechaCreacion;
    private String fechaCreacionT;
    private Double tipoCambio;
}
