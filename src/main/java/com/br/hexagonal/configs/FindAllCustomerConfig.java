package com.br.hexagonal.configs;

import com.br.hexagonal.adapters.out.FindAllCustomerOutputAdapter;
import com.br.hexagonal.application.core.usecase.FindAllCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindAllCustomerConfig {
    @Bean
    public FindAllCustomerUseCase findAllCustomerUseCase(FindAllCustomerOutputAdapter findAllCustomerOutputAdapter){
        return new FindAllCustomerUseCase(findAllCustomerOutputAdapter);
    }
}
