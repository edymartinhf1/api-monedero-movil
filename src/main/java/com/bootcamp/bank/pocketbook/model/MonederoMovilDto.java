package com.bootcamp.bank.pocketbook.model;

import lombok.Data;

@Data
public class MonederoMovilDto {
    private String numeroDocumento;
    private String tipoDocumento;
    private String numeroCelular;
    private String correo;
}
