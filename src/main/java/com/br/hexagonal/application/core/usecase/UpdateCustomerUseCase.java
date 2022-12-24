package com.br.hexagonal.application.core.usecase;

import com.br.hexagonal.application.core.model.Customer;
import com.br.hexagonal.application.ports.in.FindByIdCustomerInputPort;
import com.br.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.br.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.beans.BeanUtils;

import java.util.Optional;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {
    private final UpdateCustomerOutputPort updateCustomerOutputPort;
    private final FindByIdCustomerInputPort findByIdCustomerInputPort;

    public UpdateCustomerUseCase(UpdateCustomerOutputPort updateCustomerOutputPort, FindByIdCustomerInputPort findByIdCustomerInputPort) {
        this.updateCustomerOutputPort = updateCustomerOutputPort;
        this.findByIdCustomerInputPort = findByIdCustomerInputPort;
    }

    @Override
    public Optional<Customer> update(Customer customer, Long id) {
        return findByIdCustomerInputPort.findById(id).map(customerOld ->{
            customer.setId(customerOld.getId());
            var newCustomer = updateCustomerOutputPort.update(customer);
            BeanUtils.copyProperties(newCustomer.get(), customerOld);
            return Optional.of(customerOld);
        }).orElse(Optional.empty());
    }
}
