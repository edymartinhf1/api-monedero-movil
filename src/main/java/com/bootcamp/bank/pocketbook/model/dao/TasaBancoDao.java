package com.bootcamp.bank.pocketbook.model.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document("tasasmonederosP2P")
public class TasaBancoDao {
    @Id
    private String id;
    private String tipoTasa;
    private LocalDateTime fechaCreacion;
    private String fechaCreacionT;
    private Double tipoCambio;

}
