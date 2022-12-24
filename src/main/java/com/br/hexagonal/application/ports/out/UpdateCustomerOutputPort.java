package com.br.hexagonal.application.ports.out;

import com.br.hexagonal.application.core.model.Customer;

import java.util.Optional;

public interface UpdateCustomerOutputPort {
    Optional<Customer> update(Customer customer);
}
