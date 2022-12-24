package com.br.hexagonal.application.ports.in;

import com.br.hexagonal.application.core.model.Customer;

import java.util.Optional;

public interface DeleteByIdCustomerInputPort {
    Optional<Customer> delete(Long id);
}
