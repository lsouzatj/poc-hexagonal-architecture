package com.br.hexagonal.application.ports.out;

import com.br.hexagonal.application.core.model.Customer;

public interface InsertCustomerOutputPort {
    Customer save(Customer customer);
}
