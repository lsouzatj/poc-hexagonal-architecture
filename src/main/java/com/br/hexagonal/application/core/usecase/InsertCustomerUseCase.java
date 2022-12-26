package com.br.hexagonal.application.core.usecase;

import com.br.hexagonal.application.core.model.Address;
import com.br.hexagonal.application.core.model.Customer;
import com.br.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.br.hexagonal.application.ports.out.FindAddressByZipCodeOutput;
import com.br.hexagonal.application.ports.out.InsertCustomerOutputPort;
import org.springframework.beans.BeanUtils;

import java.util.Optional;

public class InsertCustomerUseCase implements InsertCustomerInputPort {
    private final InsertCustomerOutputPort insertCustomerOutputPort;
    private final FindAddressByZipCodeOutput findAddressByZipCodeOutput;

    public InsertCustomerUseCase(InsertCustomerOutputPort insertCustomerOutputPort, FindAddressByZipCodeOutput findAddressByZipCodeOutput) {
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.findAddressByZipCodeOutput = findAddressByZipCodeOutput;
    }

    @Override
    public Customer save(Customer customer, String zipCode) {
        var addressResponse = findAddressByZipCodeOutput.findByZipCode(zipCode);
        if (Optional.ofNullable(addressResponse).isPresent()){
            customer.setAddress(addressResponse);
            customer.setCep(zipCode);
            var customerSaved = insertCustomerOutputPort.save(customer);
            return customerSaved;
        }
        return null;
    }
}
