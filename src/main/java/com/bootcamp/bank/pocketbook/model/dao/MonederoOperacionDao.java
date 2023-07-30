package com.bootcamp.bank.pocketbook.model.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("monederooperaciones")
@Data
public class MonederoOperacionDao {
    @Id
    private String id;
    private String idCliente;
    private String tipoOperacion;
    private String numeroCelular;
    private String numeroMonedero;
    private String fechaOperacion;
    private LocalDateTime fechaCreacion;
    private String fechaCreacionT;
    private Double importe;



}
