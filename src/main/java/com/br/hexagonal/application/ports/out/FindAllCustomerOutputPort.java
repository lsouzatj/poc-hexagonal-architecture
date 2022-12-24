package com.br.hexagonal.application.ports.out;

import com.br.hexagonal.application.core.model.Customer;

import java.util.List;

public interface FindAllCustomerOutputPort {
    List<Customer> findAll();
}
