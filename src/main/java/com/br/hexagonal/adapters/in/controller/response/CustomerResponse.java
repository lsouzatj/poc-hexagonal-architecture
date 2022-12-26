package com.br.hexagonal.adapters.in.controller.response;

import com.br.hexagonal.application.core.model.Address;
import lombok.Data;

@Data
public class CustomerResponse {
    private Long id;
    private String name;
    private String cpf;
    private String cep;
    private Address address;
}
