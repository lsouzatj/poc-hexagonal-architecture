package com.br.hexagonal.adapters.out;

import com.br.hexagonal.adapters.out.repository.CustomerRepository;
import com.br.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.br.hexagonal.application.core.model.Customer;
import com.br.hexagonal.application.ports.out.InsertCustomerOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InsertCustomerOutputAdapter implements InsertCustomerOutputPort {

    private final CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        BeanUtils.copyProperties(customer, customerEntity);
        var customerSaved = customerRepository.save(customerEntity);
        BeanUtils.copyProperties(customerSaved, customer);
        return customer;
    }
}
