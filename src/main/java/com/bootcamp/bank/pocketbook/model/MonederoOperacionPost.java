package com.bootcamp.bank.pocketbook.model;

import lombok.Data;

@Data
public class MonederoOperacionPost {
    private String id;
    private String idCliente;
    private String tipoOperacion;
    private String numeroCelular;
    private String numeroMonedero;
    private String fechaOperacion;
    private Double importe;






}
