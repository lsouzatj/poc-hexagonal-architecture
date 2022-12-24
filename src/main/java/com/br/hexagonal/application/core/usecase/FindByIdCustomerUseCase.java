package com.br.hexagonal.application.core.usecase;

import com.br.hexagonal.application.core.model.Customer;
import com.br.hexagonal.application.ports.in.FindByIdCustomerInputPort;
import com.br.hexagonal.application.ports.out.FindByIdOutputPort;

import java.util.Optional;

public class FindByIdCustomerUseCase implements FindByIdCustomerInputPort {
    private final FindByIdOutputPort findByIdOutputPort;

    public FindByIdCustomerUseCase(FindByIdOutputPort findByIdOutputPort) {
        this.findByIdOutputPort = findByIdOutputPort;
    }

    @Override
    public Optional<Customer> findById(Long id) {
         var customerOptional = findByIdOutputPort.findById(id);
         return customerOptional;
    }
}