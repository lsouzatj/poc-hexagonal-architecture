package com.br.hexagonal.application.ports.out;

import com.br.hexagonal.adapters.out.clients.response.AddressResponse;
import com.br.hexagonal.application.core.model.Address;

public interface FindAddressByZipCodeOutput {
    Address findByZipCode(String zipCode);
}
