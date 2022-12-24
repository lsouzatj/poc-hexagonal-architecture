package com.br.hexagonal.adapters.in.controller.response;

import lombok.Data;

import java.util.UUID;

@Data
public class CustomerResponse {
    private UUID id;
    private String name;
    private String cpf;
}
