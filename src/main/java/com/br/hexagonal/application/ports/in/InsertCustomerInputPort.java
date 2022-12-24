package com.br.hexagonal.application.ports.in;

import com.br.hexagonal.application.core.model.Customer;

public interface InsertCustomerInputPort {
    Customer save(Customer customer);
}
