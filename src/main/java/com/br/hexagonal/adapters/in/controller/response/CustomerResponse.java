package com.br.hexagonal.adapters.in.controller.response;

import lombok.Data;

@Data
public class CustomerResponse {
    private Long id;
    private String name;
    private String cpf;
}
