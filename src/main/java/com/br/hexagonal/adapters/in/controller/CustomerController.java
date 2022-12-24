package com.br.hexagonal.adapters.in.controller;

import com.br.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.br.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.br.hexagonal.application.core.model.Customer;
import com.br.hexagonal.application.ports.in.DeleteByIdCustomerInputPort;
import com.br.hexagonal.application.ports.in.FindAllCustomerInputPort;
import com.br.hexagonal.application.ports.in.FindByIdCustomerInputPort;
import com.br.hexagonal.application.ports.in.InsertCustomerInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final InsertCustomerInputPort insertCustomerInputPort;
    private final FindAllCustomerInputPort findAllCustomerInputPort;
    private final FindByIdCustomerInputPort findByIdCustomerInputPort;
    private final DeleteByIdCustomerInputPort deleteByIdCustomerInputPort;

    @PostMapping("/save")
    public ResponseEntity<CustomerResponse> save(@RequestBody CustomerRequest customerRequest){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerRequest, customer);
        var customerSaved = insertCustomerInputPort.save(customer);
        CustomerResponse customerResponse = new CustomerResponse();
        BeanUtils.copyProperties(customerSaved, customerResponse);
        return ResponseEntity.status(HttpStatus.OK).body(customerResponse);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<CustomerResponse>> findAll(){
        List<Customer> listCustomer = findAllCustomerInputPort.findAll();
        if (!listCustomer.isEmpty()){
            List<CustomerResponse> customerResponseList = listCustomer.stream()
                    .map(customer->{
                        CustomerResponse customerResponse = new CustomerResponse();
                        BeanUtils.copyProperties(customer, customerResponse);
                        return customerResponse;
                    })
                    .collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.OK).body(customerResponseList);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable("id") Long id) {
        return findByIdCustomerInputPort.findById(id).map(customer -> {
            CustomerResponse customerResponse = new CustomerResponse();
            BeanUtils.copyProperties(customer, customerResponse);
            return ResponseEntity.status(HttpStatus.OK).body(customerResponse);
                }
        ).orElse(ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CustomerResponse> deleteById(@PathVariable("id") Long id){
        return deleteByIdCustomerInputPort.delete(id).map(customer -> {
            CustomerResponse customerResponse = new CustomerResponse();
            BeanUtils.copyProperties(customer, customerResponse);
            return ResponseEntity.status(HttpStatus.OK).body(customerResponse);
        }).orElse(ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }
}
