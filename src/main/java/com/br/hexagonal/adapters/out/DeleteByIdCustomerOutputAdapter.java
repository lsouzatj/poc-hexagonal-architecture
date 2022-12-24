package com.br.hexagonal.adapters.out;

import com.br.hexagonal.adapters.out.repository.CustomerRepository;
import com.br.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.br.hexagonal.application.core.model.Customer;
import com.br.hexagonal.application.ports.out.DeleteByIdCustomOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteByIdCustomerOutputAdapter implements DeleteByIdCustomOutputPort {
    private final CustomerRepository customerRepository;
    @Override
    public void delete(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        BeanUtils.copyProperties(customer, customerEntity);
       customerRepository.delete(customerEntity);
    }
}
