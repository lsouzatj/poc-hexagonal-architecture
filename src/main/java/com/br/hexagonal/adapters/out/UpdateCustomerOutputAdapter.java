package com.br.hexagonal.adapters.out;

import com.br.hexagonal.adapters.out.repository.CustomerRepository;
import com.br.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.br.hexagonal.application.core.model.Customer;
import com.br.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UpdateCustomerOutputAdapter implements UpdateCustomerOutputPort {

    private final CustomerRepository customerRepository;

    @Override
    public Optional<Customer> update(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        BeanUtils.copyProperties(customer, customerEntity);
        var newCustomer = customerRepository.save(customerEntity);
        BeanUtils.copyProperties(newCustomer, customer);
        return Optional.of(customer);
    }
}
