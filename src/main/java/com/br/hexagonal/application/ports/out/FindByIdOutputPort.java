package com.br.hexagonal.application.ports.out;

import com.br.hexagonal.application.core.model.Customer;

import java.util.Optional;
import java.util.UUID;

public interface FindByIdOutputPort {
    Optional<Customer> findById(Long id);
}
