package com.bootcamp.bank.pocketbook.model;

import lombok.Data;

@Data
public class MonederoMovilPost {


    private String idCliente; //Debe ser cliente del banco
    private String numeroCuentaPrincipal;
    private String numeroDocumento;
    private String tipoDocumento; // DNI , CEX , PAS =PASAPORTE
    private String numeroCelular;
    private String tipoMonedero;  // NOR = Normal  .P2P  = P2P,
    private String imeiCelular;
    private String correo;


}
