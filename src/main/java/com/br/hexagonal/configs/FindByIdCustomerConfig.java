package com.br.hexagonal.configs;

import com.br.hexagonal.adapters.out.FindByIdCustomerOutputAdapater;
import com.br.hexagonal.application.core.usecase.FindByIdCustomerUseCase;
import com.br.hexagonal.application.ports.out.FindByIdOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindByIdCustomerConfig {
    @Bean
    public FindByIdCustomerUseCase findByIdCustomerUseCase(FindByIdCustomerOutputAdapater findByIdCustomerOutputAdapater){
        return new FindByIdCustomerUseCase(findByIdCustomerOutputAdapater);
    }
}
