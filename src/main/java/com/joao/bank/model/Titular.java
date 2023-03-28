package com.joao.bank.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Titular {

    private String name;
    private String dni;
    private Long idClient;
    private String idAccount;
}