package com.br.hexagonal.configs;

import com.br.hexagonal.adapters.out.UpdateCustomerOutputAdapter;
import com.br.hexagonal.application.core.usecase.FindByIdCustomerUseCase;
import com.br.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import com.br.hexagonal.application.ports.in.FindByIdCustomerInputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {
    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(UpdateCustomerOutputAdapter updateCustomerOutputAdapter,
                                                       FindByIdCustomerUseCase findByIdCustomerUseCase){
        return new UpdateCustomerUseCase(updateCustomerOutputAdapter, findByIdCustomerUseCase);
    }
}
