package com.br.hexagonal.application.ports.out;

import com.br.hexagonal.application.core.model.Customer;

public interface DeleteByIdCustomOutputPort {
    void delete(Customer customer);
}
