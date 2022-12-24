package com.br.hexagonal.adapters.in.controller;

import com.br.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.br.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.br.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.br.hexagonal.application.core.model.Customer;
import com.br.hexagonal.application.ports.in.InsertCustomerInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final InsertCustomerInputPort insertCustomerInputPort;

    @PostMapping("/save")
    public ResponseEntity<CustomerResponse> save(@RequestBody CustomerRequest customerRequest){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerRequest, customer);
        var customerSaved = insertCustomerInputPort.save(customer);
        CustomerResponse customerResponse = new CustomerResponse();
        BeanUtils.copyProperties(customerSaved, customerResponse);
        return ResponseEntity.status(HttpStatus.OK).body(customerResponse);
    }
}
