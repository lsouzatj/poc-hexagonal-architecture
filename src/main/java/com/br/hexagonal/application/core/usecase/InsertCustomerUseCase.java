package com.br.hexagonal.application.core.usecase;

import com.br.hexagonal.application.core.model.Customer;
import com.br.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.br.hexagonal.application.ports.out.InsertCustomerOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {
    private final InsertCustomerOutputPort insertCustomerOutputPort;

    public InsertCustomerUseCase(InsertCustomerOutputPort insertCustomerOutputPort) {
        this.insertCustomerOutputPort = insertCustomerOutputPort;
    }

    @Override
    public Customer save(Customer customer) {
        var customerSaved = insertCustomerOutputPort.save(customer);
        return customerSaved;
    }
}
