package com.br.hexagonal.application.ports.in;

import com.br.hexagonal.application.core.model.Customer;

import java.util.List;

public interface FindAllCustomerInputPort {
    List<Customer> findAll();
}
