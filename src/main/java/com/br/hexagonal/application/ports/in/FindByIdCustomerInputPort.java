package com.br.hexagonal.application.ports.in;

import com.br.hexagonal.application.core.model.Customer;

import java.util.Optional;
import java.util.UUID;

public interface FindByIdCustomerInputPort {
    Optional<Customer> findById(Long id0);
}
