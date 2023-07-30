package com.bootcamp.bank.pocketbook.model.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("monederosmovil")
@Data
public class MonederoMovilDao {
    @Id
    private String id;
    private String idCLiente; //Debe ser cliente del banco
    private String numeroCuentaPrincipal;
    private String numeroMonedero;
    private String numeroDocumento;
    private String tipoDocumento;
    private String numeroCelular;
    private String correo;
    private String imeiCelular;
    private LocalDateTime fechaCreacion;
    private String fechaCreacionT;


}
