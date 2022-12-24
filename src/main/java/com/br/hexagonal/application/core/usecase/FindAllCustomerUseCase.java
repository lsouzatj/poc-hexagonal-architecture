package com.br.hexagonal.application.core.usecase;

import com.br.hexagonal.application.core.model.Customer;
import com.br.hexagonal.application.ports.in.FindAllCustomerInputPort;
import com.br.hexagonal.application.ports.out.FindAllCustomerOutputPort;

import java.util.List;

public class FindAllCustomerUseCase implements FindAllCustomerInputPort {
    private final FindAllCustomerOutputPort findAllCustomerOutputPort;

    public FindAllCustomerUseCase(FindAllCustomerOutputPort findAllCustomerOutputPort) {
        this.findAllCustomerOutputPort = findAllCustomerOutputPort;
    }

    @Override
    public List<Customer> findAll() {
        var listCustomer = findAllCustomerOutputPort.findAll();
        return listCustomer;
    }
}
