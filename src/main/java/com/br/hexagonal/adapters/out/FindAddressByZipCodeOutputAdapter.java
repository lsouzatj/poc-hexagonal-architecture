package com.br.hexagonal.adapters.out;

import com.br.hexagonal.adapters.out.clients.FindAddressByZipCodeClient;
import com.br.hexagonal.adapters.out.clients.response.AddressResponse;
import com.br.hexagonal.application.core.model.Address;
import com.br.hexagonal.application.ports.out.FindAddressByZipCodeOutput;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindAddressByZipCodeOutputAdapter implements FindAddressByZipCodeOutput {

    private final FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Override
    public Address findByZipCode(String zipCode) {
        try {
            var responseAddress = findAddressByZipCodeClient.findByZipCodeCorreios(zipCode);
            Address address = new Address();
            BeanUtils.copyProperties(responseAddress, address);
            return address;
        } catch (FeignException e) {
            if (e.status() == HttpStatus.BAD_REQUEST.value()){
                return null;
            }
        }
        return null;
    }
}
