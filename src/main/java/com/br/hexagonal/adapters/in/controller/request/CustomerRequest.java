package com.br.hexagonal.adapters.in.controller.request;

import lombok.Data;

import java.util.UUID;
@Data
public class CustomerRequest {
    private String name;
    private String cpf;
}
